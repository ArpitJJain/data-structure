package com.arpit.dynamicprogramming;

import java.util.Arrays;

/**
 * Find Maximum Sub-array
 */
public class KadaneAlgorithm {

    public long bruteForce(){
        return 0;
    }

    public long kadaneAlgorithm(int arr[]){
        if(arr == null || arr.length == 0){
            return 0;
        }

        int sum = 0;
        long max = arr[0];
        for(int i : arr){
            sum = sum + i;
            max = Math.max(max,sum);
            sum = Math.max(sum,0);
        }
        return max;
    }

    public int[] kadaneAlgorithmArr(int arr[]){
        if(arr == null || arr.length == 0){
            return null;
        }
        int sum = 0;
        int max = arr[0];
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            if(max < sum){
                max = sum;
                endIndex = i;
            }
            //max = Math.max(max,sum);
            //sum = Math.max(sum,0);
            if(sum <0){
                sum = 0;
                startIndex++;
                endIndex++;
            }
        }
        return Arrays.copyOfRange(arr,startIndex,endIndex+1);
    }
}
