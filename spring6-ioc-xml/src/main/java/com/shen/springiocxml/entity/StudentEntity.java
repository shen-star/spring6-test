package com.shen.springiocxml.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 学生实体类
 */
public class StudentEntity {
    private Logger logger = LoggerFactory.getLogger(StudentEntity.class);
    private int sid;
    private String sname;
    private Map<String, TeacherEntity> teacherMap;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Map<String, TeacherEntity> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, TeacherEntity> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public void printStudentInfo() {
        logger.info("学生id:[{}],学生姓名:[{}]", this.sid, this.sname);
        if (this.teacherMap == null) {
            return;
        }
        for (Map.Entry<String, TeacherEntity> entityEntry : this.teacherMap.entrySet()) {
            logger.info("{}课程老师信息:", entityEntry.getKey());
            logger.info("{}", entityEntry.getValue());
        }
    }

}
