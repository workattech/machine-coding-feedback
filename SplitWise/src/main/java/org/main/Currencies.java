package org.main;

import lombok.Getter;


@Getter
public enum Currencies {
    RUPEE("Rupee", "₹"),

    DOLLAR("Dollar", "$");

    private String currencyName;
    private String currencySymbol;

    Currencies(String currencyName, String currencySymbol) {
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
    }
}
