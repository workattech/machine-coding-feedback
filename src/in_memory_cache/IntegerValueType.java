package in_memory_cache;

public class IntegerValueType implements ValueType {
    public Integer value;

    public IntegerValueType(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(ValueType valueType) {
        return this.getClass() == valueType.getClass() && value.equals(((IntegerValueType) valueType).value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
