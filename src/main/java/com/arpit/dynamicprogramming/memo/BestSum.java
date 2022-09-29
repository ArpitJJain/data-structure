package com.arpit.dynamicprogramming.memo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BestSum {
    static ArrayList<Integer> bestSum(Integer targetSum, int[] arr, HashMap<Integer, ArrayList<Integer>> map) {
        if (map.containsKey(targetSum)) {
            ArrayList<Integer> cache = map.get(targetSum);
            if (cache == null){
                return null;
            }else {
                return new ArrayList<>(cache);
            }
        }
        if (targetSum < 0)
            return null;
        if (targetSum == 0)
            return new ArrayList<>();
        ArrayList<Integer> shortestCombinations = null;
        for (int num : arr) {
            ArrayList<Integer> combination = bestSum(targetSum - num, arr, map);
            if (combination != null) {
                combination.add(num);
                if (shortestCombinations == null || combination.size() < shortestCombinations.size()) {
                    shortestCombinations = combination;
                }
            }
        }
       if(shortestCombinations != null) {
           map.put(targetSum, new ArrayList(shortestCombinations));
           return new ArrayList(shortestCombinations);
       }else{
           map.put(targetSum,null);
           return null;
       }
    }

    public static void main(String[] args) {
        printArr(bestSum(10, new int[]{1, 5}, new HashMap<Integer, ArrayList<Integer>>()));
        printArr(bestSum(100,new int[]{1,2,5,25},new HashMap<Integer, ArrayList<Integer>>()));
        //System.out.println(count(new int[] {1,2,3},3,new HashMap<>()));
        //System.out.println(count(new int[] {1,2,3},5,new HashMap<>()));
        printArr(bestSum(5,new int[]{1,2,3,5},new HashMap<Integer, ArrayList<Integer>>()));
        printArr(bestSum(7,new int[]{2,3},new HashMap<Integer, ArrayList<Integer>>()));
        printArr(bestSum(7,new int[]{5,3,4,7},new HashMap<Integer, ArrayList<Integer>>()));
        printArr(bestSum(7,new int[]{2,4},new HashMap<Integer, ArrayList<Integer>>()));
        printArr(bestSum(8,new int[]{2,3,5},new HashMap<Integer, ArrayList<Integer>>()));
        printArr(bestSum(300,new int[]{7,3,14,100},new HashMap<Integer, ArrayList<Integer>>()));

    }

    static void printArr(ArrayList<Integer> list) {
        if (list == null) {
            System.out.println("null");
            return;

        }
        list.stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
    }
}
