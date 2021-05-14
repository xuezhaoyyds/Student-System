package com.ithiema.dao;

import com.ithiema.domain.Student;
import com.ithiema.factory.StudentDaoFactory;

import java.util.ArrayList;

//数据存储，库管
public class OtherStudentDao implements BaseStudentDao{
    private static ArrayList<Student> stus = new ArrayList<Student>();

    @Override
    public boolean addStudent(Student stu) {

        stus.add(stu);
        return true;
    }

    public Student[] findAllStudent() {
        Student[] students = new Student[stus.size()];
        for (int i = 0; i < students.length; i++) {
            students[i] = stus.get(i);
        }
        return students;
    }

    public void deleteStudentById(String delid) {
        //1：查找id在容器中所在的索引位置
        int index = getIndex(delid);

        stus.remove(index);
    }
    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < stus.size(); i++) {
            Student stu = stus.get(i);
            if (stu != null && stu.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateStudent(String id, Student stu) {
        int index = getIndex(id);
        stus.set(index,stu);
    }
}
