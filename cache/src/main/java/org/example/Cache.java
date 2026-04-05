package org.example;

import org.example.cache.policies.LRUEvictionPolicy;
import org.example.cache.storage.HashMapStorage;
import org.example.cache.storage.Storage;
import org.example.cache.policies.EvictionPolicy;

import java.util.concurrent.CompletableFuture;

public class Cache<Key,Value> {
    private final Storage<Key, Value> storage;
    private final EvictionPolicy<Key> evictionPolicy;
    private final KeyBasedExecutor executor;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage, int threadCount) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
        this.executor = new KeyBasedExecutor(threadCount);
    }

    public CompletableFuture<Void> putAsync(Key k, Value v) {
        CompletableFuture<Void> future = new CompletableFuture<>();
        executor.submit(k, () -> {
            try {
                storage.add(k, v);
                evictionPolicy.keyAccessed(k);
                future.complete(null);
            } catch (Exception e) {
                Key keyToRemove = evictionPolicy.evictKey();
                if (keyToRemove == null) {
                    future.completeExceptionally(new RuntimeException("Eviction failed"));
                    return;
                }
                storage.remove(keyToRemove);
                // Retry after eviction
                putAsync(k, v).thenAccept(future::complete)
                        .exceptionally(ex -> { future.completeExceptionally(ex); return null; });
            }
        });
        return future;
    }

    public CompletableFuture<Value> getAsync(Key k) {
        CompletableFuture<Value> future = new CompletableFuture<>();
        executor.submit(k, () -> {
            try {
                Value value = storage.get(k);
                evictionPolicy.keyAccessed(k);
                future.complete(value);
            } catch (RuntimeException e) {
                future.complete(null);  // key not present
            }
        });
        return future;
    }

    public void shutdown() {
        executor.shutdown();
    }


    public static void main(String[] args) {
        EvictionPolicy<String> evictionPolicy = new LRUEvictionPolicy<>();
        Storage<String, String> storage = new HashMapStorage<>(2);

        Cache<String, String> cache = new Cache<>(evictionPolicy, storage, 4); // 4 threads

        cache.putAsync("1", "one").join();
        cache.putAsync("2", "two").join();

        cache.getAsync("1").thenAccept(v -> System.out.println("Get 1: " + v)).join();
        cache.putAsync("3", "three").join(); // Should evict key "2"

        cache.getAsync("2").thenAccept(v -> System.out.println("Get 2 (should be null): " + v)).join();
        cache.getAsync("3").thenAccept(v -> System.out.println("Get 3: " + v)).join();

        cache.shutdown();
    }
}