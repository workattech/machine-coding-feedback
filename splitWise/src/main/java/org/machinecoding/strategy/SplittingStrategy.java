package org.machinecoding.strategy;

import java.util.List;

public interface SplittingStrategy {
    List<Double> getSplit(Double amount);
}
