package com.arpit.problems.pod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a row wise sorted matrix of size R*C where R and C are always odd, find the median of the matrix.
 */
public class GFGPOD20221115 {

    static int numberOfSubsequences(String S, String W){
        // code here
        return 0;
    }

    @Test
    public void test(){
        assertEquals(2,numberOfSubsequences("abcdrtbwerrcokokokd","bcd"));
    }

    @Test
    public void test1(){
        assertEquals(2,numberOfSubsequences("ascfret","qwer"));
    }
}
