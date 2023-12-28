package src.splitwise;

public interface ExpenseType {
    public static final DoubleHelper doubleHelper = new DoubleHelper();
    public static final AppConfig appConfig = AppConfig.getInstance();

    public void validateExpense() throws IllegalArgumentException;

    public void addExpense();
}