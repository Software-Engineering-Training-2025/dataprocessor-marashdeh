package org.example.dataprocessor.analyze;

import java.util.List;

public class MEAN implements analysisType {

    @Override
    public double analyze(List<Integer> list) {
        return list.isEmpty() ? Double.NaN : list.stream().mapToDouble((i) -> (double)i).average().orElse(Double.NaN);
    }

}

