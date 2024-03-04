package com.siemens.rank;

import cn.hutool.log.StaticLog;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class GetRank {
    public static void main(String[] args) {
        List<HealthTable> list = initList();
        printList(list);
        int seg = list.size() * 30 / 100;
        StaticLog.info("********前30%的数据********");
        List<HealthTable> newList = list.subList(0, seg);
        printList(newList);

    }


    // 0.39约等于0.4, 0.52约等于0.5
    private static List<HealthTable> initList() {
        List<HealthTable> resultList = Lists.newArrayList();
        resultList.add(new HealthTable("分销商1", 0.1, ""));
        resultList.add(new HealthTable("分销商2", 0.9, ""));
        resultList.add(new HealthTable("分销商3", 0.6, ""));
        resultList.add(new HealthTable("分销商4", 0.33, ""));
        resultList.add(new HealthTable("分销商5", 0.21, ""));
        resultList.add(new HealthTable("分销商6", 0.71, ""));
        resultList.add(new HealthTable("分销商7", 0.88, ""));
        resultList.add(new HealthTable("分销商8", 0.56, ""));
        resultList.add(new HealthTable("分销商9", 0.11, ""));
        resultList.add(new HealthTable("分销商10", 0.99, ""));
        resultList.add(new HealthTable("分销商11", 0.99, ""));
        resultList.add(new HealthTable("分销商12", 0.99, ""));
        resultList.add(new HealthTable("分销商13", 0.99, ""));
        resultList.add(new HealthTable("分销商14", 0.99, ""));
        return resultList;
    }

    private static void printList(List<HealthTable> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        for (HealthTable healthTable : list) {
            StaticLog.info("{}", healthTable);
        }
    }
}
