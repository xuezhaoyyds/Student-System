package com.ithiema.controller;

import com.ithiema.domain.Student;
import com.ithiema.service.StudentService;

import java.util.Scanner;

//与客户进行打交道
public abstract class BaseStudentController {
    //开启学生管理系统，进行菜单展示
    private StudentService studentService = new StudentService();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        lo:
        while (true) {
            System.out.println("-----欢迎来到学生管理系统");
            System.out.println("请输入您的选择：1.添加学生2.删除学生3.修改学生4.查看学生5.退出");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    //System.out.println("1.添加学生");
                    addStudent();
                    break;
                case "2":
                    //System.out.println("2.删除学生");
                    deleteStudentById();
                    break;
                case "3":
                    //System.out.println("3.修改学生");
                    updateStudent();
                    break;
                case "4":
                    //System.out.println("4.查看学生");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("感谢您的使用！");
                    break lo;
                default:
                    System.out.println("您的输入有误！");
            }
        }
    }

    public void updateStudent() {
        //1：调用StudentService的方法(findAllStudent)，得到学生数组
        Student[] stus = studentService.findAllStudent();
        //2：判断数组地址是否为null，是的话，提示查无信息
        if (stus == null) {
            System.out.println("无学生信息");
            return;
        }

        String id;
        while (true) {
            System.out.println("请输入学生id");
            id = sc.nextLine();
            boolean exists = studentService.isExists(id);
            if (!exists) {
                System.out.println("您输入的id不存在，请重新输入");
            } else {
                break;
            }
        }
        Student stu = getStudent(id);
        studentService.updateStudent(id, stu);
        System.out.println("修改成功");
    }

    public void deleteStudentById() {
        //1：调用StudentService的方法(findAllStudent)，得到学生数组
        Student[] stus = studentService.findAllStudent();
        //2：判断数组地址是否为null，是的话，提示查无信息
        if (stus == null) {
            System.out.println("无学生信息");
            return;
        }
        //2：判断id在容器中是否存在，如果不存在，则需要一直录入
        String delid;
        while (true) {
            System.out.println("请输入学生id");
            delid = sc.nextLine();
            boolean exists = studentService.isExists(delid);
            if (!exists) {
                System.out.println("此id不存在，请重新输入：");
            } else
                break;
        }

        //3：调用StudentService的方法(deleteStudentById)，根据id删除学生
        studentService.deleteStudentById(delid);
        System.out.println("删除成功");
    }

    public void findAllStudent() {
        //调用service中的findallstudeny（）
        Student[] stus = studentService.findAllStudent();
        //判断数组是否为null
        if (stus == null) {
            System.out.println("查无此学生信息");
            return;
        }
        //遍历数组，打印信息
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
            if (stu != null) {
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
            }
        }
    }


    public void addStudent() {
        //键盘录入学生信息

      //  Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入学号：");
            id = sc.nextLine();
            boolean flag = studentService.isExists(id);
            if (flag) {
                System.out.println("该id已存在");
            } else {
                break;
            }
        }
        Student stu = getStudent(id);
        //创建StudentService对象，调用他的addStudent()方法

        boolean result = studentService.addStudent(stu);
        //输出打印到控制台
        if (result) {
            System.out.println("添加成功");
        } else
            System.out.println("添加失败");
    }

    public abstract Student getStudent(String id);
}
