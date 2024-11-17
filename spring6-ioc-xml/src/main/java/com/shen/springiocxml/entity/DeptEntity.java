package com.shen.springiocxml.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 部门实体类
 */

public class DeptEntity {
    private static final Logger logger = LoggerFactory.getLogger(DeptEntity.class);
    private String dName;

    private List<EmpEntity> empList;

    public List<EmpEntity> getEmpList() {
        return empList;
    }

    public void setEmpList(List<EmpEntity> empList) {
        this.empList = empList;
    }

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

    public void printEmpList() {
        if (this.empList == null) {
            return;
        }
        for (EmpEntity empEntity : this.empList) {
            logger.info("{}", empEntity);
        }
    }
}
