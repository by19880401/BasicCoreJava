package com.objectiva.projectdemo.DIM417605;

import cn.hutool.log.StaticLog;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String exportType = "both";
        int payrollExtractedEmpMultiplier = 10;
        int accrualExtractedEmpMultiplier = 100;
        String output = getExtractedEmpMultiplier(exportType, payrollExtractedEmpMultiplier, accrualExtractedEmpMultiplier);
        StaticLog.info("output: {}", output);

    }

    private static String getExtractedEmpMultiplier(String exportType, int payrollExtractedEmpMultiplier, int accrualExtractedEmpMultiplier) {
        StringBuffer extractedEmpMultiplier = new StringBuffer();
        Optional<ExportTypeEnum> exportTypeEnumOpt = ExportTypeEnum.resolve(exportType);
        if (!exportTypeEnumOpt.isPresent()) {
            return extractedEmpMultiplier.toString();
        }
        ExportTypeEnum exportTypeEnum = exportTypeEnumOpt.get();
        switch (exportTypeEnum) {
            case PAYROLL:
                extractedEmpMultiplier.append(payrollExtractedEmpMultiplier);
                break;
            case ACCRUAL:
                extractedEmpMultiplier.append(accrualExtractedEmpMultiplier);
                break;
            case BOTH:
                extractedEmpMultiplier.append("payroll multiplier: ").append(payrollExtractedEmpMultiplier).append(",accrual multiplier: ").append(accrualExtractedEmpMultiplier);
                break;
        }
        return extractedEmpMultiplier.toString();
    }
}
