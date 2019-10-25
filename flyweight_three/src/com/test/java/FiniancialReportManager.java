package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-24 15:56
 * @Description:(描述)
 */

/**
 * 创建员工工资报表
 */
public class FiniancialReportManager implements IReportManager{

    /**
     *  tenantId : 享元对象的内部状态, 使用该系统的公司名称
     */
    private String tenantId = null;

    FiniancialReportManager(String tenantId){
        this.tenantId = tenantId;
    }

    /**
     * employeeName: 享元模式的外部状态
     */
    @Override
    public String createReport(String employeeName) {
        return "create FiniancialReport:"+employeeName;
    }
}
