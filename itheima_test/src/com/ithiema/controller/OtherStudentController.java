package com.ithiema.controller;

import com.ithiema.domain.Student;
import com.ithiema.service.StudentService;

import java.util.Scanner;

//与客户进行打交道
public class OtherStudentController extends BaseStudentController{
    //开启学生管理系统，进行菜单展示
   // private StudentService studentService = new StudentService();
    private Scanner sc = new Scanner(System.in);


    @Override
    public Student getStudent(String id) {
        System.out.println("请输入姓名：");
        String name = sc.nextLine();
        System.out.println("请输入年龄：");
        String age = sc.nextLine();
        System.out.println("请输入生日：");
        String birthday = sc.nextLine();
        //将学生信息封装为学生对象
        Student stu = new Student(name,age,id,birthday);
        return stu;
    }
}
