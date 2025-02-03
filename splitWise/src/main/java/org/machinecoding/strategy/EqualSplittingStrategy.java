package org.machinecoding.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EqualSplittingStrategy implements SplittingStrategy {
    private final int numUsers;

    public EqualSplittingStrategy(int numUsers) {
        this.numUsers = numUsers;
    }

    @Override
    public List<Double> getSplit(Double amount) {
        List<Double> share = new ArrayList<>();
        for (int i = 0; i < numUsers; i++) {
            share.add(roundToTwoDecimalPlaces(amount / numUsers));
        }
        return share;
    }

    private Double roundToTwoDecimalPlaces(Double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
