package in_memory_cache;

public class StringValueType implements ValueType {
    public String value;

    public StringValueType(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(ValueType valueType) {
        return this.getClass() == valueType.getClass() && value.equals(((StringValueType) valueType).value);
    }

    @Override
    public String toString() {
        return value;
    }
}
