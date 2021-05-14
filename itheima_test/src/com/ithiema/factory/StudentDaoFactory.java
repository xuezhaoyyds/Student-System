package com.ithiema.factory;

import com.ithiema.dao.BaseStudentDao;
import com.ithiema.dao.OtherStudentDao;
import com.ithiema.dao.StudentDao;

public class StudentDaoFactory {
    public static BaseStudentDao getStudentDao(){
        return new StudentDao();
    }
}
