package com.example.bigdecimal;

import java.math.BigDecimal;

/**
 * @author baiyang
 * @date 2021/7/2
 */
public class AddDemo {
    public static void main(String [] args){
        /**加数和被加数，一个是double，一个是string，是否要以相加？*/
        Double one = 0.1D;
        String two = "0.2";
        // 不推荐，double类型参数，传入BigDecimal构造，会造成数据不准确
        BigDecimal bd1 = new BigDecimal(one).add(new BigDecimal(two));
        // 推荐，可以先转成string类型参数，传入BigDecimal构造，再运算
        BigDecimal bd2 = new BigDecimal(String.valueOf(one)).add(new BigDecimal(two));
        System.out.println("-->" + bd1);
        System.out.println("-->" + bd2);

        /**
         * -->0.3000000000000000055511151231257827021181583404541015625
         * -->0.3
         * 疑问：为什么两次执行的结果会不一致？
         *详细解释见【印象笔记：JAVA BigDecimal的构造double类型】一文
         */
    }
}
