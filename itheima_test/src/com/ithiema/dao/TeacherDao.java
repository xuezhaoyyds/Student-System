package com.ithiema.dao;

import com.ithiema.domain.Teacher;

public class TeacherDao {
    public static Teacher[] tea = new Teacher[5];

    public boolean addTeacher(Teacher teacher) {
        int index = -1;
        for (int i = 0; i < tea.length; i++) {
            Teacher teacher1 = tea[i];
            if(teacher1 == null){
                index = i;
                break;
            }
        }
        if(index == -1){
            return false;
        }
        else{
            tea[index]= teacher;
            return true;
        }

    }

    public Teacher[] findAllTeacher() {
        return tea;
    }

    public void deleteTeacherById(String id) {
        int index = getIndex(id);

        tea[index] = null;
    }

    private int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < tea.length; i++) {
            Teacher teacher = TeacherDao.tea[i];
            if(teacher!=null&&teacher.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateTeacher(String id,Teacher teacher) {
        int index = getIndex(id);
        tea[index] = teacher;
    }
}
