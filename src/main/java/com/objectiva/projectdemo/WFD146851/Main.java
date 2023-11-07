package com.objectiva.projectdemo.WFD146851;

import cn.hutool.log.StaticLog;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GeneralLedgerCodeMappingSetupDTO alLedgerMappingSetupDto = initList();
        alLedgerMappingSetupDto.getGeneralLedgerMappings().stream().filter(glCodeMappingDto -> null !=glCodeMappingDto.getInput() && CommonConstants.BASIC_CATEGORY_TYPE.equals(glCodeMappingDto.getInput().getCategoryType().getName()))
                .map(glCodeMappingDto -> validateGeneralLedgerCodeMappingSetup(glCodeMappingDto)).forEach(inputCombination -> {
                    StaticLog.info("checking " + inputCombination.toString());
                });

        StaticLog.info("here....");
    }

    private static InputCombination validateGeneralLedgerCodeMappingSetup(GeneralLedgerCodeMappingDTO glCodeMappingDto) {
        return new InputCombination(glCodeMappingDto.getInput().getBasicType().getId(), glCodeMappingDto.getInputTypeValue().getId(), glCodeMappingDto.getInputType().getId());
    }

    private static GeneralLedgerCodeMappingSetupDTO initList() {
        GeneralLedgerCodeMappingSetupDTO generalLedgerCodeMappingSetupDTO = new GeneralLedgerCodeMappingSetupDTO();
        GeneralLedgerCodeMappingDTO generalLedgerCodeMappingDTO = new GeneralLedgerCodeMappingDTO();
        InputDTO inputDTO = new InputDTO();
        CommonIdAndNameDTO commonIdAndNameDTO = new CommonIdAndNameDTO();
        commonIdAndNameDTO.setId(-1L);
        commonIdAndNameDTO.setName("Basic");
        inputDTO.setCategoryType(commonIdAndNameDTO);
        generalLedgerCodeMappingDTO.setInput(inputDTO);
        generalLedgerCodeMappingSetupDTO.setGeneralLedgerMappings(Arrays.asList(generalLedgerCodeMappingDTO));
        return generalLedgerCodeMappingSetupDTO;
    }

}
