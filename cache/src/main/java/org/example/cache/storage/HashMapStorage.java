package org.example.cache.storage;


import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key,Value> implements Storage<Key,Value> {
    Map<Key, Value> storage;
    private final Integer capacity;

    public HashMapStorage(Integer capacity) {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void add(Key k, Value v) {
     if(storage.size()==capacity)
         throw  new RuntimeException("Cache is Full");
     else
         storage.put(k,v);
    }

    @Override
    public Value get(Key k) {
        if(!storage.containsKey(k))
        {
            throw new RuntimeException("Key is not available");
        }
            return storage.get(k);

    }

    @Override
    public void remove(Object k) {
      storage.remove(k);
    }
}
