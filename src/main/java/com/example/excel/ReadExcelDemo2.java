package com.example.excel;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author baiyang
 * @date 2021/6/22
 */
public class ReadExcelDemo2 {
    private static final String TITLE_NAME = "实体单元名称";
    private static final String TITLE_START = "（实际）开始时间";
    private static final String TITLE_END = "（实际）结束时间";
    private static final String TITLE_NO_PROGRESS = "截止上月末累计完成比例（%）";
    private static final String TITLE_COM_PROGRESS = "本月实际完成比例（%）";
    private static final String TITLE_ENTITY_ID = "实体单元编码";

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private static String parseObject(Object obj) {
        if (Objects.isNull(obj)) {
            return "";
        }
        if (obj instanceof Date) {
            Date dateVal = (Date)obj;
            return DateUtil.format(dateVal, DATE_FORMAT);
        } else if (obj instanceof Long) {
            Long longVal = (Long)obj;
            return Long.toString(longVal);
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("C:\\Users\\qianyy\\Downloads\\新塘1标2021年7月实际进度.xlsx"));
        List<Map<String, Object>> list = reader.readAll();
        List<ImportOrExportVo> voList = new ArrayList<>();
        list.stream().forEach(map -> {
            ImportOrExportVo vo = new ImportOrExportVo();
            String titleName = (String)map.get(TITLE_NAME);
            String titleStart = parseObject(map.get(TITLE_START));
            String titleEnd = parseObject(map.get(TITLE_END));
            String titleNoProgress = parseObject(map.get(TITLE_NO_PROGRESS));
            String titleComProgress = parseObject(map.get(TITLE_COM_PROGRESS));
            String titleEntityId = (String)map.get(TITLE_ENTITY_ID);
            vo.setWbsName(StringUtils.isBlank(titleName) ? "" : titleName);
            vo.setStartStr(StringUtils.isBlank(titleStart) ? "" : titleStart);
            vo.setEndStr(StringUtils.isBlank(titleEnd) ? "" : titleEnd);
            vo.setLastMonthEndPlanProgress(StringUtils.isBlank(titleNoProgress) ? "" : titleNoProgress);
            vo.setMonthActualProgress(StringUtils.isBlank(titleComProgress) ? "" : titleComProgress);
            vo.setWebsId(StringUtils.isBlank(titleEntityId) ? "" : titleEntityId);
            voList.add(vo);
        });

        voList.stream().forEach(v->{
            if(StringUtils.equals("013#>碎石土垫层",v.getWbsName())){
                return;/** 由于是匿名内部类的关系，此处的return相当于continue;*/
            }
            System.out.println(v);
        });

        /**
         * ImportOrExportVo{wbsName='013#>碎石土垫层', startStr='2021-03-01', endStr='', lastMonthEndPlanProgress='0.0', monthActualProgress='50.0', websId='15127923e9164b94bcb676166cc2d87c', question='null'}
         * ImportOrExportVo{wbsName='009#>砂垫层', startStr='2021-03-01', endStr='', lastMonthEndPlanProgress='0.0', monthActualProgress='50.0', websId='6ec20ff2e16c4dcdbabea373e1a0f390', question='null'}
         * ImportOrExportVo{wbsName='001#>总则(造价扩展)', startStr='2021-03-01', endStr='2021-04-28', lastMonthEndPlanProgress='0.0', monthActualProgress='', websId='1336925941584fb1ac5d3bc852fb018e', question='null'}
         * ImportOrExportVo{wbsName='004#>石方路基', startStr='2021-03-01', endStr='', lastMonthEndPlanProgress='0.0', monthActualProgress='50.0', websId='98b6467fc39242e799626d4c3f9e5222', question='null'}
         * ImportOrExportVo{wbsName='003#>石方路基', startStr='2021-03-01', endStr='', lastMonthEndPlanProgress='0.0', monthActualProgress='50.0', websId='8702732a413a4073844ad703fd192ee3', question='null'}
         * ImportOrExportVo{wbsName='005#>土工合成材料处治层', startStr='2021-03-01', endStr='', lastMonthEndPlanProgress='0.0', monthActualProgress='50.0', websId='b53f7b68668c4864acb3a8730b8342d8', question='null'}
         * ImportOrExportVo{wbsName='008#>塑料排水板', startStr='2021-03-01', endStr='', lastMonthEndPlanProgress='0.0', monthActualProgress='50.0', websId='7a22df8c7d184e7cba2ce1fbcb5b0077', question='null'}
         * ImportOrExportVo{wbsName='007#>袋装砂井', startStr='2021-03-01', endStr='', lastMonthEndPlanProgress='0.0', monthActualProgress='50.0', websId='af95e4c759904e69b36b858ddfa0444e', question='null'}
         * ImportOrExportVo{wbsName='006#>砂垫层', startStr='2021-03-01', endStr='', lastMonthEndPlanProgress='0.0', monthActualProgress='50.0', websId='f7405b78c15640bb812b6b90d93e0684', question='null'}
         * ImportOrExportVo{wbsName='011#>碎石垫层', startStr='2021-03-01', endStr='', lastMonthEndPlanProgress='0.0', monthActualProgress='50.0', websId='e5816bf465664e52a7004063d06e9d34', question='null'}
         * ImportOrExportVo{wbsName='014#>碎石垫层', startStr='2021-01-01', endStr='2021-01-14', lastMonthEndPlanProgress='100.0', monthActualProgress='', websId='067c8643f2654c5f886c758845a8aa3f', question='null'}
         * ImportOrExportVo{wbsName='015#>碎石土垫层', startStr='2021-03-01', endStr='', lastMonthEndPlanProgress='0.0', monthActualProgress='50.0', websId='a99d69680f43488999de373ddc2c827f', question='null'}
         * ImportOrExportVo{wbsName='010#>塑料排水板', startStr='2021-03-01', endStr='', lastMonthEndPlanProgress='0.0', monthActualProgress='50.0', websId='31eb51bc2d634767bc14862aad0a788f', question='null'}
         * ImportOrExportVo{wbsName='002#>土方路基', startStr='2021-01-03', endStr='2021-04-28', lastMonthEndPlanProgress='50.0', monthActualProgress='', websId='2c232da79fee41fc9e8dc66debe02d14', question='null'}
         * ImportOrExportVo{wbsName='012#>碎石土垫层', startStr='2021-03-01', endStr='', lastMonthEndPlanProgress='0.0', monthActualProgress='50.0', websId='b8760ee1072c43f5be33701d49403430', question='null'}
         */
    }
}
