package org.example.dataprocessor.analyze;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TOP3_FREQUENT_COUNT_SUM implements analysisType {
    public double analyze(List<Integer> data) {
        if (data.isEmpty()) {
            return (double)0.0F;
        } else {
            Map<Integer, Long> freq = (Map)data.stream().collect(Collectors.groupingBy((i) -> i, Collectors.counting()));
            return (double)freq.entrySet().stream().sorted((a, b) -> {
                int cmp = Long.compare((Long)b.getValue(), (Long)a.getValue());
                return cmp == 0 ? Integer.compare((Integer)a.getKey(), (Integer)b.getKey()) : cmp;
            }).limit(3L).mapToLong(Map.Entry::getValue).sum();
        }
    }
}