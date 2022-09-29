package com.arpit.dynamicprogramming.tabular;

import java.util.HashMap;

public class CanSum {
    static boolean canSum(int targerSum, int[] data){
       boolean [] cache = new boolean[targerSum+1];
       cache[0] = true;

       for(int i = 0; i < targerSum; i++){
           for(int j = 0; j<data.length; j++){
               if(cache[i] && i+data[j] < cache.length ){
                   cache[i+data[j] ] = true;
               }
           }
       }
       return cache[targerSum];
    }

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3}));
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}));
        System.out.println(canSum(7, new int[]{2, 4}));
        System.out.println(canSum(8, new int[]{2, 3, 5}));
        System.out.println(canSum(300, new int[]{7, 14}));

    }
}
