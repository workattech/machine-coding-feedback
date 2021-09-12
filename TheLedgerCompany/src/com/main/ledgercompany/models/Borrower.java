package com.main.ledgercompany.models;

import java.util.List;

public class Borrower {
    String name;
    String bankName;
    int principal;
    int timePeriod;
    double ratePercent;
    List<Payment> payments;
    public Borrower(String name, String bankName, int principal, int timePeriod, double ratePercent) {
        this.name = name;
        this.bankName = bankName;
        this.principal = principal;
        this.timePeriod = timePeriod;
        this.ratePercent = ratePercent;
    }


    public String getName() {
        return name;
    }

    public int getPrincipal() {
        return principal;
    }

    public void setPrincipal(int principal) {
        this.principal = principal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(int timePeriod) {
        this.timePeriod = timePeriod;
    }

    public double getRatePercent() {
        return ratePercent;
    }

    public void setRatePercent(double ratePercent) {
        this.ratePercent = ratePercent;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
