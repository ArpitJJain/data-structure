package com.arpit.problems.pod;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.
 */
public class GFGPOD20221101 {

    int median(int matrix[][], int R, int C) {

        return 0;
    }

    @Test
    public void test(){
        assertEquals(5,median(new int[][]{
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}},3,3));
    }

    @Test
    public void test1(){
        assertEquals(2,median(new int[][]{
                {1},
                {2},
                {3}},3,1));
    }
}
