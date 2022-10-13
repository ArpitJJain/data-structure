package com.arpit.dynamicprogramming.memo;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubStringLength {
    public static int lcs(String s1, String s2, Map<String, Integer> memo){
        if(memo.containsKey(s1+"_"+s2)){
            return memo.get(s1+"_"+s2);
        }
        if(s1 == null || s2 == null || s1.length() ==0 || s2.length() == 0){
            return 0;
        }
        if(s1.charAt(0) == s2.charAt(0)){

            int val =  1 + lcs(s1.substring(1),s2.substring(1),memo);
            memo.put(s1+"_"+s2,val);
            return val;
        }else{
            int t1 = lcs(s1.substring(1),s2,memo);
            int t2 = lcs(s1,s2.substring(1),memo) ;
            int val =  Math.max(t1 , t2);
            memo.put(s1+"_"+s2,val);
            return val;
        }
    }

    public static void main(String[] args) {
       // System.out.println(lcs("abcde","ace", new HashMap<>()));
       // System.out.println(lcs("abcdefghijklmnopqrstuvwxyz","a1b1c1d1e1f1g1h1i1j1k1l1m1n1o1p1q1r1s1t1u1v1w1x1y1z1", new HashMap<>()));
        System.out.println(lcs("ABCDGH" ,"ACDGHR",new HashMap<>()));
    }
}
