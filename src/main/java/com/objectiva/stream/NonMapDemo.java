package com.objectiva.stream;

import cn.hutool.log.StaticLog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NonMapDemo {

    public static void main(String[] args) {
        List<Long> ids = Arrays.asList(1L, 2L);//Original ids: [1, 2], Filtered ids: [3, 4]
//        List<Long> ids = Arrays.asList();// Original ids: [], Filtered ids: []
//        List<Long> ids = new ExampleObj().getIds(); // Original ids: [], Filtered ids: []
        List<Long> filteredIds = ids.stream().map(refId -> refId +2L).collect(Collectors.toList());
        StaticLog.info("Original ids: {}, Filtered ids: {}", ids, filteredIds);
    }
}
