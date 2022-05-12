package domain;

public enum ExpenseType {
    EQUAL("EQUAL"),
    EXACT("EXACT"),
    PERCENT("PERCENT");

    private final String expenseName;

    ExpenseType(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getExpenseName() {
        return expenseName;
    }
}
