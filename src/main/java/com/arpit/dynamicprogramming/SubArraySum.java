package com.arpit.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public static void main(String[] args) {
        int [] test = {2,4,6,10};
        int sum = 16;

        System.out.println(getSubArrayCount(test,sum));
    }

    private static int getSubArrayCount(int[] test, int sum) {
        Map<String, Integer> map = new HashMap<>();
        return getSubArrayCount(test,sum,test.length -1, map);
    }

    private static int getSubArrayCount(int[] test, int sum,int index,Map<String,Integer> map) {
        if(sum == 0){
            return 1;
        }
        String key = sum+":"+index;
        Integer i = map.get(key);
        if(i != null){
            return i;
        }
        if(sum < 0){
            return 0;
        }

//        return getSubArrayCount(test,sum,);

        return 1;
    }
}
