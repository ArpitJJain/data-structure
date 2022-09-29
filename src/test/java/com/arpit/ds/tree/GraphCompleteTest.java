package com.arpit.ds.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GraphCompleteTest {

    @Test
    void bfsOfGraphItr() {
        GraphComplete gc = new GraphComplete();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        result.add(2);
        result.add(3);
        result.add(4);
        ArrayList<ArrayList<Integer>> test = getTestGraph();

        int node = 5;
        assertEquals(result,gc.bfsOfGraphItr(node,test));
    }

    @Test
    void dfsOfGraphItr() {
        GraphComplete gc = new GraphComplete();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(3);
        result.add(2);
        result.add(4);
        result.add(1);
        ArrayList<ArrayList<Integer>> test = getTestGraph();

        int node = 5;
        assertEquals(result,gc.dfsOfGraphItr(node,test));
    }

    @Test
    void bfsOfGraphRec() {
        GraphComplete gc = new GraphComplete();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        result.add(2);
        result.add(3);
        result.add(4);
        ArrayList<ArrayList<Integer>> test = getTestGraph();

        int node = 5;
        assertEquals(result,gc.bfsOfGraphRec(node,test));
    }

    @Test
    void dfsOfGraphRec() {
        GraphComplete gc = new GraphComplete();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        result.add(2);
        result.add(4);
        result.add(3);

        ArrayList<ArrayList<Integer>> test = getTestGraph();

        int node = 5;
        assertEquals(result,gc.dfsOfGraphRec(node,test));
    }

    private ArrayList<ArrayList<Integer>> getTestGraph(){
        ArrayList<ArrayList<Integer>> test = new ArrayList<>();
        /*
                     1
                     |
            3 <----> 0 <---->2 <----> 4

            // Depth First = 0,2,4,3,1
            // Breadth First = 0,1, 2 ,3,4

        */
        ArrayList<Integer> t0 = new ArrayList<>();
        t0.add(1);
        t0.add(2);
        t0.add(3);


        ArrayList<Integer> t1 = new ArrayList<>();
        t1.add(0);

        ArrayList<Integer> t2 = new ArrayList<>();
        t2.add(0);
        t2.add(4);

        ArrayList<Integer> t3 = new ArrayList<>();
        t3.add(0);

        ArrayList<Integer> t4 = new ArrayList<>();
        t4.add(2);

        test.add(t0);
        test.add(t1);
        test.add(t2);
        test.add(t3);
        test.add(t4);


        return test;
    }
}