package com.arpit.dynamicprogramming.tabular;

import java.util.ArrayList;

public class BestSum {
    static ArrayList<Integer> bestSum(int targerSum, int[] data){
       ArrayList<Integer> [] cache = new ArrayList[targerSum+1];
       cache[0] = new ArrayList<>();
       for(int i = 0; i< targerSum; i++){
           for(int val :data){
               if(cache[i] != null && i+val < cache.length){
                   if(cache[i+val] == null) {
                       cache[i + val] = new ArrayList<>(cache[i]);
                       cache[i + val].add(val);
                   }
               }
           }
       }
       return cache[targerSum];
    }

    public static void main(String[] args) {
        printArr(bestSum(7, new int[]{2, 3}));
        printArr(bestSum(7, new int[]{5, 3, 4, 7}));
        printArr(bestSum(7, new int[]{2, 4}));
        printArr(bestSum(8, new int[]{2, 3, 5}));
        printArr(bestSum(300, new int[]{7, 14}));
        printArr(bestSum(10, new int[]{1,5}));
        printArr(bestSum(300, new int[]{3,10,100,150}));
    }

    private static void printArr(ArrayList<Integer> howSum) {
        if(howSum!= null && howSum.size() >0){
            howSum.forEach(s -> System.out.print(s+" "));
        }else{
            System.out.print("null");
        }
        System.out.println();
    }
}
