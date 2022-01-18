package domain;

public enum Expense {
    EQUAL("EQUAL"),
    EXACT("EXACT"),
    PERCENT("PERCENT");

    private final String expenseName;

    Expense(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getExpenseName() {
        return expenseName;
    }
}
