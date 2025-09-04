package org.example.dataprocessor.clean;

import java.util.ArrayList;
import java.util.List;

public class REMOVE_NEGATIVES implements cleaningType {


    @Override
    public List<Integer> clean(List<Integer> list) {
        List<Integer> out = new ArrayList<>(list.size());
        for (Integer n : list) {
            if (n >= 0) out.add(n);
        }
        return out;
    }
}
