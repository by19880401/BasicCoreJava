package com.example.lambda;

import com.szewec.schedule.MainClient;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToMapDemo3 {
    public static void main(String[] args) {
        Map<String, Person> pRecordMap = initRecordMap();
        System.out.println(pRecordMap);
        Map<String, List<String>> pItemMap = initItemMap();
        System.out.println(pItemMap);

        List<OutputModel> resultList = new ArrayList<>();
        pRecordMap.forEach((recordId, recordModel) -> {
            String dateStr = recordModel.getYear() + "-" + StringUtils.leftPad(recordModel.getMonth() + "", 2, "0");
            pItemMap.forEach((itemId, monthList) -> {
                if (monthList.contains(dateStr)) {
                    OutputModel output = new OutputModel();
                    output.setRecordId(recordId);
                    output.setItemId(itemId);
                    resultList.add(output);
                }
            });
        });
        resultList.stream().forEach(model -> {
            System.out.println(model);
        });

    }

    /**
     * 初始化代码，MAC格式化代码：option+command+L
     *
     * @return
     */
    private static Map<String, Person> initRecordMap() {
        List<Person> pList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Person p = new Person();
            p.setId(String.valueOf(i));
            p.setYear(2021);
            p.setMonth(i);
            pList.add(p);
        }
        return pList.stream().collect(Collectors.toMap(Person::getId, Function.identity()));
    }

    private static Map<String, List<String>> initItemMap() {
        List<Person> pList = new ArrayList<>();
        Person p1 = new Person();
        p1.setId("uuid-1");
        p1.setPlanStart(MainClient.strToDateLong("2021-01-01 00:00:00"));
        p1.setPlanEnd(MainClient.strToDateLong("2021-01-25 23:59:59"));
        pList.add(p1);
        Person p2 = new Person();
        p2.setId("uuid-2");
        p2.setPlanStart(MainClient.strToDateLong("2021-02-01 00:00:00"));
        p2.setPlanEnd(MainClient.strToDateLong("2021-03-15 23:59:59"));
        pList.add(p2);
        return pList.stream().collect(Collectors.toMap(Person::getId, p -> MainClient.getMonthBetween(p.getPlanStart(), p.getPlanEnd())));
    }
}
