package com.arpit.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public abstract class AbstractTests {

    public abstract SortInterface getSortImpl();

    @Test
    public void test_basicSort(){
        int [] data = new int[]{3,5,7,1,4,2,6,9,8};
        getSortImpl().sort(data);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9},data);
    }

    @Test
    public void test_negaticveSort(){
        int [] data = new int[]{-3,-5,-7,-1,-4,-2,-6,-9,-8};
        getSortImpl().sort(data);
        assertArrayEquals(new int[]{-9,-8,-7,-6,-5,-4,-3,-2,-1},data);
    }

    @Test
    public void test_mixedSort(){
        int [] data = new int[]{-3,-5,-7,-1,4,2,6,9,8,0};
        getSortImpl().sort(data);
        assertArrayEquals(new int[]{-7,-5,-3,-1,0,2,4,6,8,9},data);
    }

    @Test
    public void test_empty(){
        int [] data = new int[]{};
        getSortImpl().sort(data);
        assertArrayEquals(new int[]{},data);
    }

    @Test
    public void test_single(){
        int [] data = new int[]{1};
        getSortImpl().sort(data);
        assertArrayEquals(new int[]{1},data);
    }

    @Test
    public void test_allSame(){
        int [] data = new int[]{1,1,1,1,1,1,1,1,1,1,1};
        getSortImpl().sort(data);
        assertArrayEquals(new int[]{1,1,1,1,1,1,1,1,1,1,1},data);
    }

    @Test
    public void test_allSorted(){
        int [] data = new int[]{1,2,3,4,5,6,7,8,9};
        getSortImpl().sort(data);
        assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9},data);
    }

}