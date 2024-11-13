package com.shen.springiocxml.entity;

import com.shen.springiocxml.test.TestEmpEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 员工实体类
 */

public class EmpEntity {
    public static final Logger logger = LoggerFactory.getLogger(EmpEntity.class);
    private String eName;
    private String age;
    private DeptEntity deptEntity;

    private String[] hobby;

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public void printHobby() {
        for (String s : this.hobby) {
            logger.info("{}", s);
        }
    }

    @Override
    public String toString() {
        return "EmpEntity{" +
                "eName='" + eName + '\'' +
                ", age='" + age + '\'' +
                ", deptEntity=" + deptEntity +
                '}';
    }

    public DeptEntity getDeptEntity() {
        return deptEntity;
    }

    public void setDeptEntity(DeptEntity deptEntity) {
        this.deptEntity = deptEntity;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


}
