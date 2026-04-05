package org.example;


import java.util.concurrent.*;

public class KeyBasedExecutor {
    private final int numThreads;
    private final ExecutorService[] executors;

    public KeyBasedExecutor(int numThreads) {
        this.numThreads = numThreads;
        this.executors = new ExecutorService[numThreads];
        for (int i = 0; i < numThreads; i++) {
            executors[i] = Executors.newSingleThreadExecutor();
        }
    }

    private int getExecutorIndex(Object key) {
        return Math.abs(key.hashCode() % numThreads);
    }

    public void submit(Object key, Runnable task) {
        int index = getExecutorIndex(key);
        executors[index].submit(task);
    }

    public <T> Future<T> submit(Object key, Callable<T> task) {
        int index = getExecutorIndex(key);
        return executors[index].submit(task);
    }

    public void shutdown() {
        for (ExecutorService executor : executors) {
            executor.shutdown();
        }
    }
}
