package com.test.java;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-17 15:36
 * @Description:(描述)
 */
public class Test {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        System.out.println(map.get(null));
    }
}
