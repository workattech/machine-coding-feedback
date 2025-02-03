package org.machinecoding.strategy;

import java.util.List;
import java.util.stream.Collectors;

public class ExactSplittingStrategy implements SplittingStrategy{
    List<Double> exactAmount;

    public ExactSplittingStrategy(List<Double> exactAmount) {
        this.exactAmount = exactAmount;
    }

    @Override
    public List<Double> getSplit(Double amount) {
        Double sum = 0.0;
        for (Double i : exactAmount){
            sum += i;
        }

        if(!sum.equals(amount)){
            throw new IllegalArgumentException("Sum of the amounts should be equal to total expense");
        }

        return exactAmount.stream()
                .map(this::roundToTwoDecimalPlaces)
                .collect(Collectors.toList());
    }

    private Double roundToTwoDecimalPlaces(Double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
