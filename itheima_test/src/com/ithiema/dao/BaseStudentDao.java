package com.ithiema.dao;

import com.ithiema.domain.Student;

import java.util.ArrayList;

//数据存储，库管
public interface BaseStudentDao {
    //private static ArrayList<Student> stus = new ArrayList<Student>();

    public abstract boolean addStudent(Student stu);

    public abstract Student[] findAllStudent();

    public abstract void deleteStudentById(String delid);
    public abstract int getIndex(String id);

    public abstract void updateStudent(String id, Student stu);
}
