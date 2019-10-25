package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-24 16:27
 * @Description:(描述)
 */
public class Client {
    public static void main(String[] args) {
        //创建享元对象工厂
        ReportManangerFactory reportManangerFactory = new ReportManangerFactory();
        //A公司员工甲查询工资，创建A公司的报表查询接口
        IReportManager reportManagerA = reportManangerFactory.getFinancialReport("A");
        //使用查询报表功能
        String result = reportManagerA.createReport("李雷");
        System.out.println(result);

        //A公司的员工乙查询工资，也创建A公司的报表查询接口
        IReportManager reportManagerReA = reportManangerFactory.getFinancialReport("A");
        //判断两个查询接口是否是同一个对象
        System.out.println(reportManagerA == reportManagerReA);
        String result1 = reportManagerReA.createReport("migng");
        System.out.println(result1);
    }


}
