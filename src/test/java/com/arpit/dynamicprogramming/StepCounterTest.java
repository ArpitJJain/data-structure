package com.arpit.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StepCounterTest {

    @Test
    void countWays() {
        StepCounter counter = new StepCounter();
        System.out.println(counter.climbStairs(38));
    }
}