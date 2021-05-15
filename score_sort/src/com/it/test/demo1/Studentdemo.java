package com.it.test.demo1;

import java.util.TreeSet;

public class Studentdemo {
    public static void main(String[] args) {
        TreeSet<Student> set = new TreeSet<Student>();
        Student stu1 = new Student("张三",28,38,10);
        Student stu2 = new Student("李四",24,58,10);
        Student stu3 = new Student("王五",58,28,40);
        set.add(stu1);
        set.add(stu2);
        set.add(stu3);
        for (Student i:set) {
            System.out.println(i);
        }
    }
}
