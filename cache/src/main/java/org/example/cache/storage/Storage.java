package org.example.cache.storage;

public interface Storage<Key,Value> {
    void add(Key k , Value v);
    Value get(Key k);
    void remove(Key k);
}
