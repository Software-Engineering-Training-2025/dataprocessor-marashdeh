package org.example.dataprocessor.clean;

import java.util.List;

public class REPLACE_NEGATIVES_WITH_ZERO implements cleaningType {

    @Override
    public List<Integer> clean(List<Integer> list) {
        for (int i = 0; i< list.size(); i++) {
            if (list.get(i) < 0) list.set(i, 0);
        }
        return list;
    }
}
