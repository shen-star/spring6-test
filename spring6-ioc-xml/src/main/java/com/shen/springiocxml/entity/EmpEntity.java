package com.shen.springiocxml.entity;

/**
 * 员工实体类
 */

public class EmpEntity {
    private String eName;
    private String age;
    private DeptEntity deptEntity;

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
