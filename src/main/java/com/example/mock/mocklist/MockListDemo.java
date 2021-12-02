package com.example.mock.mocklist;

import java.util.ArrayList;
import java.util.List;

public class MockListDemo {

    public int getListSize() {
        List<Integer> list = getInitList();
        return list.size();
    }

    /*public Integer getSpecialElementFromList(i) {
        List<Integer> list = getInitList();
        if (null == list || list.size() == 0) {
            return 0;
        }
        return list.get(0);
    }*/

    private List<Integer> getInitList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }
}
