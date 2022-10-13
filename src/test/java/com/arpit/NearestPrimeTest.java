package com.arpit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NearestPrimeTest {

    @Test
    void nthTerm() {
        NearestPrime nearestPrime = new NearestPrime();
        nearestPrime.NthTerm(100000);
    }
}