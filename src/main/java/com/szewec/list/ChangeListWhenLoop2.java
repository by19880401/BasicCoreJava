package com.szewec.list;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 遍历中对List进行修改：添加元素或者删除元素，程序会报错
 */
public class ChangeListWhenLoop2 {
    public static void main(String[] args) {
        List<String> list = initList();
        printListInfo(list);
        /**
         * John
         * Mark
         * Allen
         * Json
         * Jack
         * Lily
         */

        // 遍历修改list
        for (String str : list) {
            if (StringUtils.equals("John", str)) {
//                list.add("Willis");// 向list添加元素
//                list.remove(str);// 从list删除元素
            }
        }
        /**Result:
         *Exception in thread "main" java.util.ConcurrentModificationException
         * 	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:909)
         * 	at java.util.ArrayList$Itr.next(ArrayList.java:859)
         * 	at com.szewec.list.ChangeListWhenLoop2.main(ChangeListWhenLoop2.java:18)
         *
         */

        /**
         * 换一种思路，用list的iterator试试
         */
        List<String> addList = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (StringUtils.equals("John", str)) {
//                it.remove();// 从list删除元素
//                addList.add(str);// 向list添加元素
            }
        }
        list.addAll(addList);
//        printListInfo(list);
        /**Result:
         * 可以正常向list添加、删除元素
         */


        /*********************************************************************/
        /**
         * 使用ListIterator：它只能对List使用，set和map等无法使用
         *（1）ListIterator有add()方法，可以向List中添加对象，而Iterator不能
         * （2）ListIterator和Iterator都有hasNext()和next()方法，可以实现顺序向后遍历，但是ListIterator有hasPrevious()和previous()方法，可以实现逆向（顺序向前）遍历。Iterator就不可以。
         * （3）ListIterator可以定位当前的索引位置，nextIndex()和previousIndex()可以实现。Iterator没有此功能。
         * （4）都可实现删除对象，但是ListIterator可以实现对象的修改，set()方法可以实现。Iierator仅能遍历，不能修改。
         *
         */
        ListIterator<String> ite = list.listIterator();
        while (ite.hasNext()) {
            String str = ite.next();
            if (StringUtils.equals("John", str)) {
//                ite.add("Willis");// 向list添加元素，原值John仍在
//                ite.set("didi");// 修改，把John替换为didi，原值John不存在
                ite.remove();//从list删除元素
            }
        }

        printListInfo(list);
    }


    private static List<String> initList() {
        List<String> resultList = new ArrayList<>();
        resultList.add("John");
        resultList.add("Mark");
        resultList.add("Allen");
        resultList.add("Json");
        resultList.add("Jack");
        resultList.add("Lily");
        return resultList;
    }

    private static void printListInfo(List list) {
        System.out.println("***************************");
        if (CollectionUtils.isEmpty(list)) {
            System.out.println("No element found.");
            return;
        }

        list.forEach(p -> System.out.println(p));
    }


}
