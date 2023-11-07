package com.objectiva.projectdemo.exception2;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Req> reqList = getReqList();
        try {
            handleLogic(reqList);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void handleLogic(List<Req> reqList) {
        reqList.stream().forEach(r -> {
            // can only contain custom field
            if ("PRIMARY".equals(StringUtils.upperCase(r.getProcessBasedOnType()))) {
                if (StringUtils.isBlank(r.getCustomField()) && !StringUtils.isBlank(r.getPositionCustomField())) {
                    throw new RuntimeException("201");
                }
                if (!StringUtils.isBlank(r.getPositionCustomField()) && !StringUtils.isBlank(r.getCustomField())) {
                    throw new RuntimeException("202");
                }
            }
        });
    }


    private static List<Req> getReqList() {
        List<Req> resultList = new ArrayList<>();
        resultList.add(new Req("PRIMARY", "yes", "yes"));
        return resultList;
    }
}
