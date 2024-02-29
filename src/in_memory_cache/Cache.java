package in_memory_cache;

import java.util.*;

public class Cache {
    Map<String, Value> keyValuePair;

    public Cache() {
        keyValuePair = new HashMap<String, Value>();
    }

    public String get(String key) throws Exception {
        if (keyValuePair.containsKey(key))
            return keyValuePair.get(key).toString();
        throw new Exception(String.format("No entry found for %s", key));
    }

    public void put(String key, Value value) throws Exception {
        if (keyValuePair.size() > 0) {
            if (value.isSimilar(keyValuePair.values().iterator().next())) {
                keyValuePair.put(key, value);
            } else {
                throw new Exception("Data Type Error");
            }
        } else {
            keyValuePair.put(key, value);
        }
    }

    public List<String> search(String attributeKey, String attributeValue) {
        List<String> listOfKeys = new ArrayList<String>();
        for (Map.Entry<String, Value> set : keyValuePair.entrySet()) {
            String key = set.getKey();
            Value value = set.getValue();
            if (value.hasAttribute(attributeKey, attributeValue)) {
                listOfKeys.add(key);
            }
        }
        Collections.sort(listOfKeys);
        return listOfKeys;
    }

    public void delete(String key) {
        keyValuePair.remove(key);
    }

    public List<String> keys() {
        List<String> listOfKeys = new ArrayList<String>();
        for (String set : keyValuePair.keySet()) {
            listOfKeys.add(set);
        }
        Collections.sort(listOfKeys);
        return listOfKeys;
    }
}
