package com.arpit.problems.pod;

import java.util.HashMap;
import java.util.Map;

public class GFGPOD20221012 {
    static String maxSum(String w,char x[],int b[], int n){
        if(w == null || w.length()<=1){
            return w;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(x[i],b[i]);
        }
        char [] chars = w.toCharArray();
        long tempSum = 0;
        long maxSum = Long.MIN_VALUE;
        int start = 0;
        String result = "";
        for(int i = 0; i < chars.length; i++){
            Integer val = map.get(chars[i]);
            if(val == null){
                tempSum = tempSum + chars[i];
            }else{
                tempSum = tempSum + val;
            }
            if(tempSum >maxSum){
                maxSum = tempSum;
                result = w.substring(start,i+1);
            }
            if(tempSum<0){
                tempSum = 0;
                start = i+1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxSum("hkghXZ",new char[]{'Z','h','X','g'},new int[]{342,-625, -904, 451},4));
        System.out.println(maxSum("abcde",new char[]{'c'},new int[]{-1000},1));
        System.out.println(maxSum("dbfbsdbf",new char[]{'b','s'},new int[]{-100,45},2));
        System.out.println(maxSum("oK",new char[]{'K','o'},new int[]{-880,53},2));
    }
}
