package com.arpit.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangesTest {

    @Test
    void test_Count() {
        CoinChanges coinChanges = new CoinChanges();

        assertEquals(4,coinChanges.count(new int[]{1, 2, 3},3,4));


    }
}