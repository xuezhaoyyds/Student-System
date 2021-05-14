package com.ithiema.service;

import com.ithiema.dao.TeacherDao;
import com.ithiema.domain.Teacher;

public class TeacherService {

    private TeacherDao teacherDao = new TeacherDao();



    public boolean addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    public boolean isExists(String id) {
        TeacherDao teacherDao = new TeacherDao();
        Teacher[] teas = teacherDao.findAllTeacher();
        boolean exists = false;
        for (int i = 0; i < teas.length; i++) {
            Teacher teacher = teas[i];
            if (teacher != null && teacher.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    public Teacher[] findAllTeacher() {
        Teacher[] tea = teacherDao.findAllTeacher();
        boolean flag = false;
        for (int i = 0; i < tea.length; i++) {
            if (tea[i] != null) {
                flag = true;
                break;
            }
        }
        if(flag){
            return tea;
        }else{
            return null;
        }
    }

    public void deleteTeacherById(String id) {
        teacherDao.deleteTeacherById(id);
    }

    public void updateTeacher(String id,Teacher teacher) {
        teacherDao.updateTeacher(id,teacher);
    }
}
