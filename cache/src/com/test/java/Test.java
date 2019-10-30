package com.test.java;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: java_performance_optimization
 * @Author:chenxuebing
 * @Date:2019-10-09 8:49
 * @Description:(描述)
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<String> linkedList = new LinkedList<>();
        ArrayList arrayList = new ArrayList();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap(16,0.75f,true);
        linkedHashMap.put("w","q");
        linkedHashMap.put("a","1");
        linkedHashMap.put("b","2");
        linkedHashMap.get("w");
        for(String s : linkedHashMap.values()){
            System.out.println(s);
        }
        HashMap<String, String> map = new HashMap();
        map.put("b","q");
        map.put("a","1");
        map.put("a","hhh");
        map.put("g","2");
        map.get("a");
        for(String s1 : map.values()){
            System.out.println(s1);
        }
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("a","v");
        treeMap.get("a");
        HashSet<String> set = new HashSet<>();
        System.out.println(set.add("a")); //true
        System.out.println(set.add("a")); //false
        System.out.println(set.size());
        for(Iterator it = set.iterator() ; it.hasNext() ;  ){
            it.next();
        }
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("ss");
    }
}
