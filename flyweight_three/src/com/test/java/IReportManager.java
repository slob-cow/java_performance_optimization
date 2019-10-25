package com.test.java;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-09-24 15:47
 * @Description:(描述)
 */

/**
 *  抽象享元类
 *
 *  需求：
 *  --： 一个SAAS(software AS A Service)软件应用模式的人事管理系统，该系统提供给甲、乙、丙三家公司使用
 *       1.甲、乙、丙各有100名员工，员工可以登录系统，查询自己的工资报表。
 *       2.甲、乙、丙公司各有自己对应的数据库，可以为甲、乙、丙提供对应的查询接口。
 *
 */

public interface IReportManager {
    /**
     * 该接口的作用是创建报表
     */
    public String  createReport(String employeeName);
}
