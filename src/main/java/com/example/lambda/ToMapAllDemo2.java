package com.example.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Collectors.toMap 作用是将List转成map
 * @author baiyang
 * @date 2021/6/29
 */
public class ToMapAllDemo2 {
    private static final Integer MAX_VAL = 6;
    /**
     *
     * Collectors.toMap(key,v->v,(v1,v2)->v1)，是为了解决当key重复时的数据冲突问题
     *
     * //其中key 就是map得key值
     * //第二个参数就是map得value
     *
     * //第三个参数的作用是当出现一样的key值得时候如何取舍其中V1代表旧值，v2代表新值，示例中取旧值
     *
     */
    public static void main(String[] args) {
        List<Person> pList = initList();
        // 打印
        pList.stream().forEach(p -> System.out.println(p));
        // 转为map，key：id, value: name
        Map<String, String> pMap = pList.stream().collect(Collectors.toMap(Person::getId, p -> p.getName(), (v1, v2) -> v1 + "," + v2));
        pMap.forEach((k, v) -> System.out.println("key:" + k + ",value:" + v));

        /**
         * (1) (v1,v2)->v1, 当key重新时，即map里有两个相同一key时，value使用原来的旧值，the result is as follows:
         * Person{id='1', name='willis-1', year=2021, month=1, planStart=null, planEnd=null}
         * Person{id='2', name='willis-2', year=2021, month=2, planStart=null, planEnd=null}
         * Person{id='3', name='willis-3', year=2021, month=3, planStart=null, planEnd=null}
         * Person{id='4', name='willis-4', year=2021, month=4, planStart=null, planEnd=null}
         * Person{id='5', name='willis-5', year=2021, month=5, planStart=null, planEnd=null}
         * Person{id='2', name='Lucy&Lily', year=2020, month=6, planStart=null, planEnd=null}
         * key:1,value:willis-1
         * key:2,value:willis-2
         * key:3,value:willis-3
         * key:4,value:willis-4
         * key:5,value:willis-5
         * (2) (v1,v2)->v2, 当key重新时，即map里有两个相同一key时，value使用后来的新值，the result is as follows:
         * Person{id='1', name='willis-1', year=2021, month=1, planStart=null, planEnd=null}
         * Person{id='2', name='willis-2', year=2021, month=2, planStart=null, planEnd=null}
         * Person{id='3', name='willis-3', year=2021, month=3, planStart=null, planEnd=null}
         * Person{id='4', name='willis-4', year=2021, month=4, planStart=null, planEnd=null}
         * Person{id='5', name='willis-5', year=2021, month=5, planStart=null, planEnd=null}
         * Person{id='2', name='Lucy&Lily', year=2020, month=6, planStart=null, planEnd=null}
         * key:1,value:willis-1
         * key:2,value:Lucy&Lily
         * key:3,value:willis-3
         * key:4,value:willis-4
         * key:5,value:willis-5
         * (3)(v1, v2) -> v1 + "," + v2)，当key重新时，即map里有两个相同一key时，value使用"新值,旧值"的格式
         * Person{id='1', name='willis-1', year=2021, month=1, planStart=null, planEnd=null}
         * Person{id='2', name='willis-2', year=2021, month=2, planStart=null, planEnd=null}
         * Person{id='3', name='willis-3', year=2021, month=3, planStart=null, planEnd=null}
         * Person{id='4', name='willis-4', year=2021, month=4, planStart=null, planEnd=null}
         * Person{id='5', name='willis-5', year=2021, month=5, planStart=null, planEnd=null}
         * Person{id='2', name='Lucy&Lily', year=2020, month=6, planStart=null, planEnd=null}
         * key:1,value:willis-1
         * key:2,value:willis-2,Lucy&Lily
         * key:3,value:willis-3
         * key:4,value:willis-4
         * key:5,value:willis-5
         *
         */
    }

    private static List<Person> initList() {
        List<Person> resultList = new ArrayList<>();
        for (int i = 1; i < MAX_VAL; i++) {
            Person p = new Person();
            p.setId(String.valueOf(i));
            p.setYear(2021);
            p.setMonth(i);
            p.setName("willis-" + i);
            resultList.add(p);
        }
        Person p0 = new Person();
        p0.setId("2");
        p0.setYear(2020);
        p0.setMonth(6);
        p0.setName("Lucy&Lily");
        resultList.add(p0);
        return resultList;
    }
}
