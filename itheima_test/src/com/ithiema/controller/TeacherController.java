package com.ithiema.controller;

import com.ithiema.domain.Teacher;
import com.ithiema.service.TeacherService;

import java.util.Scanner;

public class TeacherController {

    private Scanner sc = new Scanner(System.in);
    private TeacherService teacherService = new TeacherService();

    public void start() {
        lo:
        while (true) {
            System.out.println("-----欢迎来到教师管理系统");
            System.out.println("请输入您的选择：1.添加教师2.删除教师3.修改教师4.查看教师5.退出");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    //System.out.println("1.添加教师");
                    addTeacher();
                    break;
                case "2":
                    //System.out.println("2.删除教师");
                    deleteTeacherById();
                    break;
                case "3":
                    //System.out.println("3.修改教师");
                    updateTeacher();
                    break;
                case "4":
                    //System.out.println("4.查看教师");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("感谢您的使用！");
                    break lo;
                default:
                    System.out.println("您的输入有误！");
            }
        }


    }

    public void updateTeacher() {
        Teacher[] teacher = teacherService.findAllTeacher();
        if (teacher == null) {
            System.out.println("无教师信息，请添加后重试");
            return;
        }
        //判断id是否存在
        String id;
        while (true) {
            System.out.println("请输入教师编号");
            id = sc.nextLine();
            boolean flag = teacherService.isExists(id);
            if (!flag) {
                System.out.println("此id不存在，请重新输入");
            } else
                break;
        }
        System.out.println("请输入姓名：");
        String name = sc.nextLine();
        System.out.println("请输入年龄：");
        String age = sc.nextLine();
        System.out.println("请输入生日：");
        String birthday = sc.nextLine();
        Teacher tea = new Teacher(name, age, id, birthday);

        teacherService.updateTeacher(id,tea);
        System.out.println("修改成功");
    }

    public void deleteTeacherById() {
        Teacher[] teacher = teacherService.findAllTeacher();
        if (teacher == null) {
            System.out.println("无教师信息，请添加后重试");
            return;
        }
        //判断id是否存在
        String id;
        while (true) {
            System.out.println("请输入教师编号");
            id = sc.nextLine();
            boolean flag = teacherService.isExists(id);
            if (!flag) {
                System.out.println("此id不存在，请重新输入");
            } else
                break;
        }
        teacherService.deleteTeacherById(id);
        System.out.println("删除成功");
    }

    public void findAllTeacher() {
        Teacher[] teacher = teacherService.findAllTeacher();
        if (teacher == null) {
            System.out.println("无教师信息，请添加后重试");
            return;
        }
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < teacher.length; i++) {
            Teacher tea = teacher[i];
            if (tea != null) {
                System.out.println(tea.getId()+" "+tea.getName()+" "+tea.getAge()+" "+tea.getBirthday());
            }
        }
    }

    public void addTeacher() {
        //判断id是否存在
        String id;
        while (true) {
            System.out.println("请输入教师编号");
            id = sc.nextLine();
            boolean flag = teacherService.isExists(id);
            if (flag) {
                System.out.println("此id已存在");
            } else
                break;
        }
        System.out.println("请输入姓名：");
        String name = sc.nextLine();
        System.out.println("请输入年龄：");
        String age = sc.nextLine();
        System.out.println("请输入生日：");
        String birthday = sc.nextLine();
        Teacher tea = new Teacher(name, age, id, birthday);

        boolean flag = teacherService.addTeacher(tea);
        if (flag) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }
}
