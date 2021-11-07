package com.example.mock.mockstatic;

import java.util.List;

/**
 * this class use the static methods of Utility
 */
public class UtilityHelper {
    public int sum(List<Integer> dataLst) {
        if (Utility.listIsNullOrEmpty(dataLst)) {
            return 0;
        }

        int total = 0;
        for (Integer data : dataLst) {
            total += data;
        }

        return total;
    }

    public int product(List<Integer> dataList) {
        int total = 1;
        if (Utility.listIsNotNullOrEmpty(dataList)) {
            for (Integer data : dataList) {
                total *= data;
            }
        }

        return total;
    }
}
