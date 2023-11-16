package com.objectiva.stream;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * 利用steam对list中的对象进行排序
 */
public class ListSortDemo {
    public static void main(String[] args) {
        //测试数据，请不要纠结数据的严谨性
        List<StudentInfo> studentList = new ArrayList<>();
        studentList.add(new StudentInfo("李小明", true, 18, 1.76, LocalDate.of(2001, 3, 23)));
        studentList.add(new StudentInfo("张小丽", false, 18, 1.61, LocalDate.of(2001, 6, 3)));
        studentList.add(new StudentInfo("王大朋", true, 19, 1.82, LocalDate.of(2000, 3, 11)));
        studentList.add(new StudentInfo("陈小跑", false, 17, 1.67, LocalDate.of(2002, 10, 18)));

        // print student before sort
        StudentInfo.printStudentInfo(studentList);
        /**
         * [姓名]		[性别]		[年龄]		[身高]		[生日]
         * ----------------------------------------------------------
         * StudentInfo(name=李小明, gender=true, age=18, height=1.76, birthday=2001-03-23)
         * StudentInfo(name=张小丽, gender=false, age=18, height=1.61, birthday=2001-06-03)
         * StudentInfo(name=王大朋, gender=true, age=19, height=1.82, birthday=2000-03-11)
         * StudentInfo(name=陈小跑, gender=false, age=17, height=1.67, birthday=2002-10-18)
         */

        //按年龄排序(Integer类型)
        //这里需要特别注意：必须要用一个新的list(defaultNewStudentList)来接排过序的list(studentList)
        List<StudentInfo> defaultNewStudentList = studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge)).collect(Collectors.toList());//默认按照升序排
        // print student after sorted
        StudentInfo.printStudentInfo(defaultNewStudentList);
        /**
         * [姓名]		[性别]		[年龄]		[身高]		[生日]
         * ----------------------------------------------------------
         * StudentInfo(name=陈小跑, gender=false, age=17, height=1.67, birthday=2002-10-18)
         * StudentInfo(name=李小明, gender=true, age=18, height=1.76, birthday=2001-03-23)
         * StudentInfo(name=张小丽, gender=false, age=18, height=1.61, birthday=2001-06-03)
         * StudentInfo(name=王大朋, gender=true, age=19, height=1.82, birthday=2000-03-11)
         */

        // 如果想按照降序排，怎么办？加个reversed即可,下面：使用年龄进行降序排序，年龄相同再使用身高升序排序
        List<StudentInfo> descNewStudentList = studentList.stream().sorted(Comparator.comparing(StudentInfo::getAge).reversed().thenComparing(StudentInfo::getHeight)).collect(Collectors.toList());
        /**
         * [姓名]		[性别]		[年龄]		[身高]		[生日]
         * ----------------------------------------------------------
         * StudentInfo(name=王大朋, gender=true, age=19, height=1.82, birthday=2000-03-11)
         * StudentInfo(name=张小丽, gender=false, age=18, height=1.61, birthday=2001-06-03)
         * StudentInfo(name=李小明, gender=true, age=18, height=1.76, birthday=2001-03-23)
         * StudentInfo(name=陈小跑, gender=false, age=17, height=1.67, birthday=2002-10-18)
         */
        StudentInfo.printStudentInfo(descNewStudentList);

    }
}
