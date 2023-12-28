package src.splitwise;

import java.util.List;

public interface Balances {
    public static final AppConfig appConfig = AppConfig.getInstance();

    public List<String> getBalances() throws IllegalArgumentException;
}
