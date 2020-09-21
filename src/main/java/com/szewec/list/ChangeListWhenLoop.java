package com.szewec.list;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChangeListWhenLoop {

    public static void main(String[] args) {
        List<Person> initList = initializingList();
        printPersonInfo(initList);
        // 尝试修改其中一条记录的属性值
        for (Person p : initList) {
            if (1 == p.getId().intValue()) {
                p.setSex("man");
            } else {
                p.setSex("woman");
            }
        }

        printPersonInfo(initList);


        Iterator<Person> it = initList.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            if (0 == p.getId()) {
                it.remove();
            }
        }

        printPersonInfo(initList);

    }

    private static void printPersonInfo(List personList) {
        System.out.println("***************************");
        if (CollectionUtils.isEmpty(personList)) {
            System.out.println("No person found.");
            return;
        }

        personList.forEach(p -> System.out.println(p.toString()));
    }


    private static List<Person> initializingList() {
        List<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 2; i++) {
            Person p = new Person();
            p.setId(i);
            p.setName("Potter G" + i);
            list.add(p);
        }
        return list;

    }


    public static class Person {
        private Integer Id;
        private String name;
        private String sex;// man or woman

        public Integer getId() {
            return Id;
        }

        public String getName() {
            return name;
        }

        public void setId(Integer id) {
            Id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "Id=" + Id +
                    ", name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }


}
