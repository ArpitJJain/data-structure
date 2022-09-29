package com.arpit.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProductSubarrayTest {

    @Test
    void maxProduct() {
        MaxProductSubarray subarray = new MaxProductSubarray();
        int [] test = new int[]{6 ,-3 ,-10 ,0 ,2};
assertEquals(180,subarray.maxProduct(test));
        test = new int[]{-8, 5 ,3, 1, 6};
        assertEquals(90,subarray.maxProduct(test));
    }
}