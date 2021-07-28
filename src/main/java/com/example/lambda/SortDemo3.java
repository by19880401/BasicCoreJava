package com.example.lambda;

import cn.hutool.log.StaticLog;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/7/28
 * @
 */
public class SortDemo3 {
    public static void main(String[] args) {
        //数字排序
        NumSort();
        //字符串排序
        stringSort();
        //对象排序
        new SortDemo3().ObjectSort();


    }

    /**
     * 数字排序
     * 输入：[4, 2, 5, 3, 1]
     * ASC：[1, 2, 3, 4, 5]
     * DESC：[5, 4, 3, 2, 1]
     */
    private static void NumSort() {
        List<Integer> list = Arrays.asList(4, 2, 5, 3, 1);
        StaticLog.info("original--{}", list);
        // ASC
        list.sort((a, b) -> a.compareTo(b.intValue()));
        StaticLog.info("ASC-->{}", list);
        // DESC
        list.sort((a, b) -> b.compareTo(a.intValue()));
        StaticLog.info("DESC-->{}", list);
    }

    /**
     * 字符串排序
     * 输入：[aa, cc, bb, ee, dd]
     * ASC：[aa, bb, cc, dd, ee]
     * DESC：[ee, dd, cc, bb, aa]
     */
    public static void stringSort() {
        List<String> list = Lists.newArrayList();
        list.add("aa");
        list.add("cc");
        list.add("bb");
        list.add("ee");
        list.add("dd");
        StaticLog.info("original-->{}", list);
        // ASC
        list.sort((a, b) -> a.compareTo(b.toString()));
        StaticLog.info("ASC-->{}", list);
        // DESC
        list.sort((a, b) -> b.compareTo(a.toString()));
        StaticLog.info("DESC-->{}", list);
    }

    /**
     * [SortDemo3.Willis(id=1, name=Willis), SortDemo3.Willis(id=2, name=Merry), SortDemo3.Willis(id=5, name=Cola), SortDemo3.Willis(id=3, name=QiQi), SortDemo3.Willis(id=4, name=David)]
     * [SortDemo3.Willis(id=1, name=Willis), SortDemo3.Willis(id=2, name=Merry), SortDemo3.Willis(id=3, name=QiQi), SortDemo3.Willis(id=4, name=David), SortDemo3.Willis(id=5, name=Cola)]
     * [SortDemo3.Willis(id=5, name=Cola), SortDemo3.Willis(id=4, name=David), SortDemo3.Willis(id=3, name=QiQi), SortDemo3.Willis(id=2, name=Merry), SortDemo3.Willis(id=1, name=Willis)]
     * 对象排序（对象某属性）
     */
    private void ObjectSort() {
        List<Willis> wList = Lists.newArrayList();
        wList.add(new Willis(1, "Willis"));
        wList.add(new Willis(2, "Merry"));
        wList.add(new Willis(5, "Cola"));
        wList.add(new Willis(3, "QiQi"));
        wList.add(new Willis(4, "David"));
        StaticLog.info("original-->{}", wList);
        wList.sort(Comparator.comparingInt(Willis::getId));//写法1
        StaticLog.info("ASC-->{}", wList);
        wList.sort((a, b) -> Integer.compare(b.getId(), a.getId()));//写法2，同写法1，两种方式均可
        StaticLog.info("DESC-->{}", wList);
    }


    @ToString
    @Data
    class Willis {
        private Integer id;
        private String name;

        public Willis(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
