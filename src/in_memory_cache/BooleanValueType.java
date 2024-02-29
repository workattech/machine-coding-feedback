package in_memory_cache;

public class BooleanValueType implements ValueType {
    public Boolean value;

    public BooleanValueType(boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(ValueType valueType) {
        return this.getClass() == valueType.getClass() && value.equals(((BooleanValueType) valueType).value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
