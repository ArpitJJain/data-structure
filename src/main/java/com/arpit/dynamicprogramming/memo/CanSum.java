package com.arpit.dynamicprogramming.memo;

import java.util.HashMap;

public class CanSum {
    static boolean canSum(int targetSum, int[] arr, HashMap<Integer, Boolean> map) {
        if (map.containsKey(targetSum))
            return map.get(targetSum);
        if (targetSum < 0)
            return false;
        if (targetSum == 0)
            return true;

        for (int i = 0; i < arr.length; i++) {
            Boolean result = canSum(targetSum - arr[i], arr, map);
            if (result) {
                map.put(targetSum, result);
                return result;
            }
        }
        map.put(targetSum, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3}, new HashMap<Integer, Boolean>()));
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}, new HashMap<Integer, Boolean>()));
        System.out.println(canSum(7, new int[]{2, 4}, new HashMap<Integer, Boolean>()));
        System.out.println(canSum(8, new int[]{2, 3, 5}, new HashMap<Integer, Boolean>()));
        System.out.println(canSum(300, new int[]{7, 14}, new HashMap<Integer, Boolean>()));
    }

}