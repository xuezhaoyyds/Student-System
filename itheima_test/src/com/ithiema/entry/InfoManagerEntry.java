package com.ithiema.entry;


import com.ithiema.controller.BaseStudentController;
import com.ithiema.controller.OtherStudentController;
import com.ithiema.controller.StudentController;
import com.ithiema.controller.TeacherController;

import java.util.Scanner;

//程序入口
public class InfoManagerEntry {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //主菜单搭建
        while (true) {
            System.out.println("------欢迎来到黑马信息系统管理");
            System.out.println("请输入您的选择：1.学生管理 2.教师管理 3.退出");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    //System.out.println("1.学生管理");
                    BaseStudentController studentController = new OtherStudentController();
                    studentController.start();
                    break;
                case "2":
                    System.out.println("2.教师管理");
                    TeacherController teacherController = new TeacherController();
                    teacherController.start();
                    break;
                case "3":
                    System.out.println("感谢您的使用！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("您的输入有误！");
            }
        }
    }
}
