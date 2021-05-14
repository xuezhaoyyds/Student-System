package com.ithiema.service;

import com.ithiema.dao.BaseStudentDao;
import com.ithiema.dao.OtherStudentDao;
import com.ithiema.dao.StudentDao;
import com.ithiema.domain.Student;
import com.ithiema.factory.StudentDaoFactory;

//业务逻辑
public class StudentService {

    private BaseStudentDao studentDao = StudentDaoFactory.getStudentDao();

    public boolean addStudent(Student stu) {
        //StudentDao studentDao = new StudentDao();
        return studentDao.addStudent(stu);
    }

    public boolean isExists(String id) {
        //创建dao对象，调用findall获取学生数组
        //StudentDao studentDao = new StudentDao();
        Student[] stus = studentDao.findAllStudent();
        //假设学生不存在
        boolean exists = false;
        //遍历数组获取每一个学生判断学号是否存在
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student != null && student.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Student[] findAllStudent() {
        //1：从StudentDao中获取存储学生对象的数组
        Student[] stus = studentDao.findAllStudent();
        //2：判断学生数组中是否有数据
        //有：返回数组地址
        //无：返回null
        //思路：数组中只要存在一个不是null的元素，那就代表有学生信息
        boolean flag = false;
        for (int i = 0; i < stus.length; i++) {
            if (stus[i] != null) {
                flag = true;
                break;
            }
        }
        if (flag) {
            return stus;
        } else {
            return null;
        }
    }

    public void deleteStudentById(String delid) {
        studentDao.deleteStudentById(delid);
    }

    public void updateStudent(String id, Student stu) {
        studentDao.updateStudent(id,stu);
    }
}
