package com.arpit.problems.pod;

import java.util.HashMap;
import java.util.Map;

public class GFGPOD20221008 {
    static int countOfSubstrings(String S, int K) {
        if(K<0){
            return -1;
        }
        int count = 0;
        char [] chars = S.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < K && i < S.length(); i++){
            addToMap(map,chars[i]);
        }
        if(map.size() == K-1){
            count++;
        }
        for(int i = K; i < S.length(); i++){
            removeFromMap(map,chars[i-K]);
            addToMap(map,chars[i]);
            if(map.size() == K-1){
                count++;
            }
        }

        return count;
    }
    static void addToMap(Map<Character, Integer> map, char c){
        Integer count = map.get(c);
        if(count == null){
            map.put(c,1);
        }else{
            map.put(c,++count);
        }
    }
    static void removeFromMap(Map<Character, Integer> map, char c){
        Integer count = map.get(c);
        if(count != null && count >1){
            map.put(c,--count);
        }else{
            map.remove(c);
        }
    }

    public static void main(String[] args) {
        System.out.println(countOfSubstrings("rdsaugup",5));
    }
}
