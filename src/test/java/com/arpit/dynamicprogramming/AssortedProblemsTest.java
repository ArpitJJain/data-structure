package com.arpit.dynamicprogramming;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
public class AssortedProblemsTest {


    @Test
    public void test_NthUglyNumber(){
        //1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15,
        AssortedProblems problems = new AssortedProblems();
        assertEquals("1",problems.nthUglyNumber(1));
        assertEquals("2",problems.nthUglyNumber(2));
        assertEquals("3",problems.nthUglyNumber(3));
        assertEquals("4",problems.nthUglyNumber(4));
        assertEquals("5",problems.nthUglyNumber(5));
        assertEquals("6",problems.nthUglyNumber(6));
        assertEquals("8",problems.nthUglyNumber(7));
        assertEquals("9",problems.nthUglyNumber(8));
        assertEquals("10",problems.nthUglyNumber(9));
        assertEquals("12",problems.nthUglyNumber(10));
        assertEquals("15",problems.nthUglyNumber(11));
    }
}
