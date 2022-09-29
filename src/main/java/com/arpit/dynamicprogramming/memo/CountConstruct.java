package com.arpit.dynamicprogramming.memo;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {
    public static int countConstruct(String target, String [] wordBank, Map<String,Integer> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target.length() == 0) {
            return 1;
        }
        int count = 0;
        for (String s : wordBank) {
            if (target.startsWith(s)) {
                int totalWay = countConstruct(target.replaceFirst(s, ""), wordBank, map);
                count = count + totalWay ;
            }
        }
            map.put(target, count);
            return count;

    }

    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef",new String[]{"ab","abc","cd","def","abcd"},new HashMap<>()));
        System.out.println(countConstruct("skateboard",new String[]{"bo","rd","ate","t","ska","sk","boar"},new HashMap<>()));
        System.out.println(countConstruct("purple",new String[]{"purp","p","ur","le","purpl"},new HashMap<>()));
        System.out.println(countConstruct("",new String[]{"bo","rd","ate","t","ska","sk","boar"},new HashMap<>()));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[]{"e","ee","eee"},new HashMap<>()));

    }
}
