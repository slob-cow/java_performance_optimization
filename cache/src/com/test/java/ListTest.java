package com.test.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-09 18:47
 * @Description:(描述)
 */
public class ListTest {
    public static void main(String[] args) {
       Object[] obj = {"a"};
        System.out.println(obj == null);
        int a = 2;
        System.out.println(5>>1);
        obj = Arrays.copyOf(obj,2);
        System.out.println(obj.length+""+obj[0]);
        List<String> link = new LinkedList();
    }
}
