package com.arpit.dynamicprogramming.tabular;

import java.util.ArrayList;
import java.util.Arrays;

public class HowSum {
    static ArrayList<Integer> howSum(int targerSum, int[] data){
       ArrayList<Integer> [] cache = new ArrayList[targerSum+1];
       cache[0] = new ArrayList<>();
       for(int i = 0; i< targerSum; i++){
           for(int val :data){
               if(cache[i] != null && i+val < cache.length){
                   cache[i+val] = new ArrayList<>(cache[i]);
                   cache[i+val].add(val);
               }
           }
       }
       return cache[targerSum];
    }

    public static void main(String[] args) {
        printArr(howSum(7, new int[]{2, 3}));
        printArr(howSum(7, new int[]{5, 3, 4, 7}));
        printArr(howSum(7, new int[]{2, 4}));
        printArr(howSum(8, new int[]{2, 3, 5}));
        printArr(howSum(300, new int[]{7, 14}));
    }

    private static void printArr(ArrayList<Integer> howSum) {
        if(howSum!= null){
            howSum.forEach(s -> System.out.print(s+" "));
        }else{
            System.out.println("null");
        }
        System.out.println();
    }
}
