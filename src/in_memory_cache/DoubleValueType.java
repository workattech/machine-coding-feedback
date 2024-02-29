package in_memory_cache;

public class DoubleValueType implements ValueType {
    public Double value;

    public DoubleValueType(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(ValueType valueType) {
        return this.getClass() == valueType.getClass() && value.equals(((DoubleValueType) valueType).value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
