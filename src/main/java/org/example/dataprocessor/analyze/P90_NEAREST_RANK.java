package org.example.dataprocessor.analyze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P90_NEAREST_RANK implements analysisType {
    public double analyze(List<Integer> data) {
        if (data.isEmpty()) {
            return Double.NaN;
        } else {
            List<Integer> sorted = new ArrayList<>(data);
            Collections.sort(sorted);
            int n = sorted.size();
            int rank = (int)Math.ceil(0.9 * (double)n);
            return (double)(Integer)sorted.get(rank - 1);
        }
    }
}