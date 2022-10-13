package com.arpit.problems.pod;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Given an array A of size N of integers. Your task is to find the sum of minimum and maximum element in the array.
 */
public class GFGPOD20221013 {
    public static int findSum(int A[],int N)
    {
        if(A == null || A.length <1){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++){
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        return min + max;
    }

    public static void main(String[] args) {
        assertEquals(1 ,findSum(new int[]{-2, 1, -4, 5, 3},5));
        assertEquals(5 ,findSum(new int[]{1, 3, 4, 1},4));

    }
}
