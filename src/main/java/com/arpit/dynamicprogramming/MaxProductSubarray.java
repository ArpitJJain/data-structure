package com.arpit.dynamicprogramming;

public class MaxProductSubarray {
    long maxProduct(int[] arr) {
        long maxProd = Long.MIN_VALUE;
        long temp = 1;
        for(int i : arr){
            temp = temp*i;
            maxProd = Math.max(temp,maxProd);
            if(temp == 0)
                temp = 1;
        }
        return maxProd;
    }
}
