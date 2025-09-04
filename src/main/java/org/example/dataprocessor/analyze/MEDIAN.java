package org.example.dataprocessor.analyze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MEDIAN implements analysisType {
    @Override
        public double analyze(List<Integer> data) {
            if (data.isEmpty()) {
                return Double.NaN;
            }
            else {
                List<Integer> sorted = new ArrayList(data);
                Collections.sort(sorted);
                int n = sorted.size();
                return n % 2 == 1 ? (double)(Integer)sorted.get(n / 2) : (double)((Integer)sorted.get(n / 2 - 1) + (Integer)sorted.get(n / 2)) / (double)2.0F;
            }
        }
    }

