package org.example.dataprocessor.analyze;

import java.util.List;

public class STD_DEV implements analysisType {
    public double analyze(List<Integer> data) {
        if (data.isEmpty()) {
            return Double.NaN;
        } else {
            double mean = data.stream().mapToDouble((i) -> (double)i).average().orElse((double)0.0F);
            double variance = data.stream().mapToDouble((i) -> Math.pow((double)i - mean, (double)2.0F)).sum() / (double)data.size();
            return Math.sqrt(variance);
        }
    }
}
