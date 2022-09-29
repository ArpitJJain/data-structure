package com.arpit.dynamicprogramming;

public class TrappingRainWater {
    public long trappingWaterBruteFore(int arr[]) {
        int result = 0;
        for(int i = 0; i < arr.length; i++) {
            result = result+ Math.min(maxLeft(arr, i), maxRight(arr, i))-arr[i];
        }
        return result;
    }



    private static int maxRight(int[] arr, int i) {
        int max = arr[i];
        while (i>=0){
            if(arr[i] > max){
                max = arr[i];
            }
            i--;
        }
        return max;
    }

    private static int maxLeft(int[] arr, int i) {
        int max = arr[i];
        while (i<arr.length){
            if(arr[i] > max){
                max = arr[i];
            }
            i++;
        }
        return max;
    }

    public long trappingWaterExtraSpace(int arr[]) {
        int [] left = getPrefixLeft(arr);
        int [] right = getPrefixRight(arr);

        long result = 0;
        for(int i = 0; i < arr.length; i++) {
            result = result+ Math.min(left[i], right[ i])-arr[i];
        }
        return result;

    }
    private static int [] getPrefixLeft(int [] arr){
        int [] result = new int[arr.length];
        result[0] = arr[0];
        for (int i = 1; i < arr.length; i++){
            if(result[i-1] > arr[i] ){
                result[i] = result[i-1];
            }else{
                result[i] = arr[i];
            }
        }
        return result;
    }
    private static int [] getPrefixRight(int [] arr){
        int [] result = new int[arr.length];
        result[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--){
            if(result[i+1] > arr[i] ){
                result[i] = result[i+1];
            }else{
                result[i] = arr[i];
            }
        }
        return result;
    }
}
