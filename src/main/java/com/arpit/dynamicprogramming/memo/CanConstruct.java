package com.arpit.dynamicprogramming.memo;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public static boolean canConstruct(String target, String [] wordBank, Map<String,Boolean> map){
        if(map.containsKey(target)){
            return map.get(target);
        }
        if(target == null){
            return false;
        }
        if(target.length() == 0){
            return true;
        }
        for(String s : wordBank){
            if(target.startsWith(s)){
                if(canConstruct(target.replaceFirst(s,""),wordBank,map)) {
                    map.put(target, true);
                    return true;
                }
            }
        }
        map.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef",new String[]{"ab","abc","cd","def","abcd"},new HashMap<>()));
        System.out.println(canConstruct("skateboard",new String[]{"bo","rd","ate","t","ska","sk","boar"},new HashMap<>()));
        System.out.println(canConstruct("",new String[]{"bo","rd","ate","t","ska","sk","boar"},new HashMap<>()));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[]{"e","ee","eee"},new HashMap<>()));

    }
}
