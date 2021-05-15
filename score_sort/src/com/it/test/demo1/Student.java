package com.it.test.demo1;

public class Student implements Comparable<Student> {
    private String name;
    private int shuxue;
    private int yuwen;
    private int english;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShuxue() {
        return shuxue;
    }

    public void setShuxue(int shuxue) {
        this.shuxue = shuxue;
    }

    public int getYuwen() {
        return yuwen;
    }

    public void setYuwen(int yuwen) {
        this.yuwen = yuwen;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public Student(String name, int shuxue, int yuwen, int english) {
        this.name = name;
        this.shuxue = shuxue;
        this.yuwen = yuwen;
        this.english = english;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", shuxue=" + shuxue +
                ", yuwen=" + yuwen +
                ", english=" + english +
                '}';
    }

    //实现一个获取总分的方法
    public int getSum() {
        return yuwen + shuxue + english;
    }

    @Override
    public int compareTo(Student o) {
        //按总成绩排序
        int result = this.getSum() - o.getSum();
        //总成绩一样就比较语文成绩
        result = result == 0?this.getYuwen() - o.getYuwen():result;
        //语文一样就比较数学
        result = result == 0?this.getShuxue()-o.getShuxue():result;
        //数学一样就比较英语

        //都一样就比较姓名
        result = result == 0?this.getName().compareTo(o.getName()):result;
        return result;
    }
}
