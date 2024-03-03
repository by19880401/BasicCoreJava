package com.siemens;

import cn.hutool.log.StaticLog;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ComparePType {
    public static void main(String[] args) {
        List<SalesStock> allRecordsInGrid = findAll();
        printList(allRecordsInGrid);
        List<SalesStock> excelList = findRecordsFromExcel();
        printList(excelList);

        for(SalesStock ss: allRecordsInGrid){
            String flag = findFlag(excelList,ss);
            StaticLog.info("ss: {} flag:{}",ss,flag);
        }
    }

    /**
     * key method
     * @param excelList
     * @param salesStock
     * @return
     */
    private static String findFlag(List<SalesStock> excelList, SalesStock salesStock){
        for(SalesStock ss: excelList){
            String key = ss.getPType() + "|" + ss.getMlfb();
            if(key.equals(salesStock.getPType()+"|"+salesStock.getMlfb())){
                return "Y";
            }
        }
        return "N";
    }

    private static List<SalesStock> findAll() {
        List<SalesStock> resultList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SalesStock ss = new SalesStock();
            ss.setMlfb(String.valueOf(i));
            ss.setPType((((i & 1) == 1) ? "PTO" : "PTS"));
            resultList.add(ss);
        }
        return resultList;
    }

    private static List<SalesStock> findRecordsFromExcel(){
        List<SalesStock> excelList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SalesStock ss = new SalesStock();
            ss.setMlfb(String.valueOf(i));
            ss.setPType("PTS");
            excelList.add(ss);
        }
        return excelList;
    }


    private static void printList(List<SalesStock> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }

        StaticLog.info("****list****");
        for (SalesStock ss : list) {
            StaticLog.info("Sales Stock: {}", ss);
        }
    }

}
