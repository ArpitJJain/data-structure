package com.arpit.dynamicprogramming.memo;

import java.util.HashMap;

public class MaxProductSubArray {
    public static Long maxProduct(int[] arr) {
        long maxMul =1, minMul = 1;
        long result = Long.MIN_VALUE;
        boolean hasZero = false;
        for( int i = 0; i<arr.length; i++){
            int currVal = arr[i];
            if(currVal == 0){
                maxMul = 1;
                minMul = 1;
                hasZero = true;
                continue;

            }
            long temp = maxMul*currVal;
            maxMul = Math.max(Math.max(maxMul*currVal, minMul*currVal),currVal);
            minMul = Math.min(Math.min(temp, minMul*currVal),currVal);
            result = Math.max(result,maxMul);
        }
        /*if(hasZero){
            return Math.max(result,0);
        }else{
            return result;
        }*/
        return  result;
    }

    public static void main(String[] args) {
        System.out.println((int)'Z');
        System.out.println(maxProduct(new int[]{8 ,-2 ,-2 ,0 ,8 ,0 ,-6, -8, -6, -1}));

        System.out.println(maxProduct(new int[]{1,2,3}));
        System.out.println(maxProduct(new int[]{1,-2,3}));
        System.out.println(maxProduct(new int[]{-2,0}));
        System.out.println(maxProduct(new int[]{-2,-3,0}));
        System.out.println(maxProduct(new int[]{-2,-1,-3}));
        System.out.println(maxProduct(new int[]{1, 2, 3, 0, 1, 2}));

    }
}