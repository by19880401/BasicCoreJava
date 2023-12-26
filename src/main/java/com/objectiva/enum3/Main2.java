package com.objectiva.enum3;

import java.util.Locale;

/**
 * 报错操作 : RuleEnum.valueOf("a");
 * <p>
 * 报错信息 : IllegalArgumentException No enum const class SqlTypeEnum.XXX，意思是没有找到定义好的枚举
 * <p>
 * 解决 :
 * <p>
 * 改为 RuleEnum rm =RuleEnum.valueOf("a".toUpperCase(Locale.ENGLISH)) , 或者 RuleEnum rm =RuleEnum.valueOf("A")
 * <p>
 * 设置不区分大小写,还有就是, RuleEnum必须有定义 A("123"),才不会报错,如下参考
 */
public class Main2 {
    public static void main(String[] args) {
        AuthorityEnum case1 = AuthorityEnum.valueOf("admin");// 报错：No enum constant com.objectiva.enum3.AuthorityEnum.admin
        AuthorityEnum case2 = AuthorityEnum.valueOf("ADMIN");//正常

        AuthorityEnum case3 = AuthorityEnum.valueOf("admin".toUpperCase());//正常
        AuthorityEnum case4 = AuthorityEnum.valueOf("admin".toUpperCase(Locale.CHINA));//正常
        AuthorityEnum case5 = AuthorityEnum.valueOf("admin1".toUpperCase());// 报错：No enum constant com.objectiva.enum3.AuthorityEnum.ADMIN1
    }

}
