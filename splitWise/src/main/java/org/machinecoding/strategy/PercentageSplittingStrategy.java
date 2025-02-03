package org.machinecoding.strategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PercentageSplittingStrategy implements SplittingStrategy{
    List<Double> percentages;

    public PercentageSplittingStrategy(List<Double> percentages){
        this.percentages = percentages;
    }

    @Override
    public List<Double> getSplit(Double amount) {
        Double sum = 0.0;
        for (Double percentage : percentages) {
            sum += percentage;
        }
        if(!sum.equals(100.0)){
            throw new IllegalArgumentException("Sum of percentage must be equal to 100");
        }

        return percentages.stream()
                .map(t -> roundToTwoDecimalPlaces(t * amount / 100.00))
                .collect(Collectors.toList());
    }

    private Double roundToTwoDecimalPlaces(Double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
