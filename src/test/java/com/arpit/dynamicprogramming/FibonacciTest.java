package com.arpit.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void nthFibonacci() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(13,fibonacci.nthFibonacci(7));
    }
}