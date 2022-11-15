package com.arpit.problems.pod;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an array A of size N of integers. Your task is to find the sum of minimum and maximum element in the array.
 */
public class GFGPOD20221031 {
    static int[] satisfyEqn(int[] A, int N) {
        int [] result = new int[]{-1,-1,-1,-1};
        Map<Integer, Integer[]> map = new HashMap<>();
        for (int  i = 0; i<N; i++){
            for(int j = i+1; j<N; j++){
                if(map.containsKey(A[i]+A[j])){
                    int[] temp = new int[4];
                    Integer [] t = map.get(A[i]+A[j]);
                    temp[0] = t[0];
                    temp[1] = t[1];
                    temp[2] = i;
                    temp[3] = j;
                    if(result[0] == -1){
                        result = temp;
                        continue;
                    }
                    for(int k = 0; k < 4; k++){
                        if(result[k]<temp[k]){
                            break;
                        }else if(result[k]>temp[k]){
                            result = temp;
                            break;
                        }
                    }
                }else{
                    map.put(A[i]+A[j],new Integer[]{i,j});
                }
            }
        }

        return result;
        // code here
    }


    @Test
    public void test1() {
        assertArrayEquals(new int[]{0,2,3,5},satisfyEqn(new int[]{3, 4, 7, 1, 2, 9, 8},7));
    }

    @Test
    public void test2() {
        assertArrayEquals(new int[]{-1,-1,-1,-1},satisfyEqn(new int[]{424, 12, 31, 7},4));
    }
}
