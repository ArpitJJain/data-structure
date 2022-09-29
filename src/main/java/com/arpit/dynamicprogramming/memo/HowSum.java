package com.arpit.dynamicprogramming.memo;

import java.util.ArrayList;
import java.util.HashMap;

public class HowSum {
    static ArrayList<Integer> howsum(int targetSum, int[] arr, HashMap<Integer, ArrayList<Integer>> map){
        if(map.containsKey(targetSum))
            return map.get(targetSum);
        if(targetSum < 0)
            return null;
        if(targetSum == 0)
            return new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            ArrayList<Integer> result = howsum(targetSum-arr[i],arr,map);
            if(result!= null){

                result.add(arr[i]);
                map.put(targetSum,result);
                return result;
            }
        }
        map.put(targetSum,null);
        return null;
    }

    public static void main(String[] args) {
        printArr(howsum(7,new int[]{2,3},new HashMap<Integer, ArrayList<Integer>>()));
        printArr(howsum(7,new int[]{5,3,4,7},new HashMap<Integer, ArrayList<Integer>>()));
        printArr(howsum(7,new int[]{2,4},new HashMap<Integer, ArrayList<Integer>>()));
        printArr(howsum(8,new int[]{2,3,5},new HashMap<Integer, ArrayList<Integer>>()));
        printArr(howsum(300,new int[]{7,14},new HashMap<Integer, ArrayList<Integer>>()));
    }
    static void printArr(ArrayList<Integer> list){
        if(list == null){
            System.out.println("null");
            return;

        }
        list.stream().forEach(s -> System.out.print(s+" "));
        System.out.println();
    }}
