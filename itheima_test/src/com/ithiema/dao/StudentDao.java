package com.ithiema.dao;

import com.ithiema.domain.Student;

//数据存储，库管
public class StudentDao implements BaseStudentDao{
    private static Student[] stus = new Student[5];


    public boolean addStudent(Student stu) {
        //创建长度为5的数组
        //将接受到的学生对象添加到数组中
        int index = -1;
        //遍历数组，查看是否为null
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if (student == null) {
                index = i;
                break;
            }
        }
        //返回是否添加成功的值
        if (index == -1) {
            return false;
        } else {
            stus[index] = stu;
            return true;
        }
    }

    public Student[] findAllStudent() {
        return stus;
    }

    public void deleteStudentById(String delid) {
        //1：查找id在容器中所在的索引位置
        int index = getIndex(delid);

        //2：将该索引位置，使用null元素覆盖
        stus[index] = null;
    }
    public int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu = StudentDao.stus[i];
            if (stu != null && stu.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateStudent(String id, Student stu) {
        int index = getIndex(id);
        stus[index] = stu;
    }
}
