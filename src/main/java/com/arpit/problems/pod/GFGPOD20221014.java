package com.arpit.problems.pod;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an array A of size N of integers. Your task is to find the sum of minimum and maximum element in the array.
 */
public class GFGPOD20221014 {
    public static int maximizeSum (int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i :arr){
            Integer c = map.get(i);
            if(c == null){
                map.put(i,1);
            }else{
                map.put(i,c+1);
            }
        }
        int total = 0;
        for(int i = n-1; i >=0; i--){
            int key = arr[i];
            Integer c = map.get(key);
            if(c != null && c > 0){
                total = total+key;
                map.put(key,c-1);

                key = arr[i]-1;
                c = map.get(key);
                if(c != null && c > 0){
                    map.put(key,c-1);
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        assertEquals(10 ,maximizeSum(new int[]{1, 2, 2, 2, 3, 4},6));
        assertEquals(4 ,maximizeSum(new int[]{1, 2, 3},3));

    }
}
