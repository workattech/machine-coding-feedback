package in_memory_cache;

import java.util.*;

public class Value {
    private Map<String, ValueType> attributes = new HashMap<String, ValueType>();
    private ValueTypeFactory valueTypeFactory = new ValueTypeFactory();

    public Value(List<String> attributes) {
        if (attributes.size() % 2 == 1) {
            throw new IllegalArgumentException("Missing key or value!");
        }
        for (int i = 0; i < attributes.size() - 1; i += 2) {
            String key = attributes.get(i);
            String value = attributes.get(i + 1);
            this.attributes.put(key, valueTypeFactory.getValueType(value));
        }
    }

    public Object getAtrributeValue(String key) {
        return attributes.get(key);
    }

    public int getNumberOfAttributes() {
        return attributes.size();
    }

    public boolean isSimilar(Value value) {
        if (getNumberOfAttributes() == value.getNumberOfAttributes()) {
            for (Map.Entry<String, ValueType> set : attributes.entrySet()) {
                if (set.getValue().getClass() != value.getAtrributeValue(set.getKey()).getClass())
                    return false;
            }
            return true;
        }
        return false;
    }

    public boolean hasAttribute(String attributeKey, String attributeValue) {
        if (!attributes.containsKey(attributeKey))
            return false;
        return attributes.get(attributeKey).equals(valueTypeFactory.getValueType(attributeValue));
    }

    @Override
    public String toString() {
        String attributesPair = "";
        for (Map.Entry<String, ValueType> set : attributes.entrySet()) {
            attributesPair += String.format("%s : %s, ", set.getKey(), set.getValue().toString());
        }
        return attributesPair;
    }
}
