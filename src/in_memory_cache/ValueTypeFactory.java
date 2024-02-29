package in_memory_cache;

public class ValueTypeFactory {
    ValueType getValueType(String value) {
        if (value.equals("true") || value.equals("false")) {
            return new BooleanValueType(Boolean.parseBoolean(value));
        } else {
            try {
                int integerValue = Integer.parseInt(value);
                return new IntegerValueType(integerValue);
            } catch (NumberFormatException e) {
                try {
                    double doubleValue = Double.parseDouble(value);
                    return new DoubleValueType(doubleValue);
                } catch (NumberFormatException e1) {
                    return new StringValueType(value);
                }
            }
        }
    }
}
