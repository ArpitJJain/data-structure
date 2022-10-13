package com.arpit;

import java.util.*;

public class CountSubstring {
    static int countOfSubstrings(String S, int K) {
        return countDistinct(S,new HashMap<>());
    }
    static int countDistinct(String s, Map<String, Integer> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(s == null || s.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
        }
        int count = set.size();
        map.put(s,count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOfSubstrings("abcc",2));
        System.out.println(countOfSubstrings("aabab",3));
    }
}
