package com.arpit.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KadaneAlgorithmTest {

    KadaneAlgorithm algorithm = new KadaneAlgorithm();

    @Test
    void kadaneAlgorithm() {
        assertEquals(7,algorithm.kadaneAlgorithm(generateTestData()));
    }

    @Test
    void kadaneAlgorithmArr() {
        int [] result = new int[] {4,-1,-2,1,5};
        assertArrayEquals(result,algorithm.kadaneAlgorithmArr(generateTestData()));
    }

    @Test
    void kadaneAlgorithm_negative() {
        assertEquals(-1,algorithm.kadaneAlgorithm(generateTestDataAllNegative()));
    }

    @Test
    void kadaneAlgorithmArr_negative() {
        int [] result = new int[] {-1};
        assertArrayEquals(result,algorithm.kadaneAlgorithmArr(generateTestDataAllNegative()));
    }

    private int [] generateTestData(){
        int [] arr = new int[8];
        arr[0] = -2;
        arr[1] = -3;
        arr[2] =  4;
        arr[3] = -1;
        arr[4] = -2;
        arr[5] =  1;
        arr[6] =  5;
        arr[7] = -3;
        return arr;
    }

    private int [] generateTestDataAllNegative(){
        int [] arr = new int[8];
        arr[0] = -2;
        arr[1] = -3;
        arr[2] = -4;
        arr[3] = -1;
        arr[4] = -2;
        arr[5] =  -1;
        arr[6] =  -5;
        arr[7] = -3;
        return arr;
    }

}