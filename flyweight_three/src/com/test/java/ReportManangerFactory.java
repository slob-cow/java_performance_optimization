package com.test.java;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-24 15:57
 * @Description:(描述)
 */
public class ReportManangerFactory {
    //存放查询工资报表的集合
    Map<String, IReportManager> financialMap = new HashMap<>();
    //存放查询员工信息报表的集合
    Map<String, IReportManager> employeeMap = new HashMap<>();

    /**
     * 获取工资报表接口对象
     * @return
     */
    public IReportManager getFinancialReport(String tenantId){
        if(financialMap.containsKey(tenantId)){
            return financialMap.get(tenantId);
        }else{
            FiniancialReportManager finiancialReportManager = new FiniancialReportManager(tenantId);
            financialMap.put(tenantId, finiancialReportManager);
            return finiancialReportManager;
        }
    }

    /**
     * 获取员工信息列表对象
     * @param tenantId
     * @return
     */
    public IReportManager getEmployeeReport(String tenantId){
        if(employeeMap.containsKey(tenantId)){
            return employeeMap.get(tenantId);
        }else{
            EemployeeReportManager employeeReportManager = new EemployeeReportManager(tenantId);
            employeeMap.put(tenantId, employeeReportManager);
            return employeeReportManager;
        }
    }
}
