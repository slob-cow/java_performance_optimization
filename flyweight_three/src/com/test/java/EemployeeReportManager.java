package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-24 15:56
 * @Description:(描述)
 */

/**
 * 享元具体类
 */
public class EemployeeReportManager implements IReportManager{
    private String tenantId = null;
    EemployeeReportManager(String tenantId){
        this.tenantId = tenantId;
    }

    @Override
    public String createReport(String employeeName) {
        return "create EemployeeReport:" + employeeName;
    }
}
