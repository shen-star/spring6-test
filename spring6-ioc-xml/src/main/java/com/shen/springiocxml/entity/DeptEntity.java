package com.shen.springiocxml.entity;

/**
 * 部门实体类
 */

public class DeptEntity {
    private String dName;

    @Override
    public String toString() {
        return "DeptEntity{" +
                "dName='" + dName + '\'' +
                '}';
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
}
