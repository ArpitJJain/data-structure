package com.arpit.ds.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TopologicalSortTest {
    static class Graph {
        private ArrayList<ArrayList<Integer>> adj;
        private int v;

        public Graph(int v) {
            adj = new ArrayList<ArrayList<Integer> >(v);
            this.v = v;
            for (int i = 0; i < v; ++i)
                adj.add(new ArrayList<Integer>());
        }

        private void addEdge(int u, int v) {
            adj.get(u).add(v);
        }
    }
    @Test
    void topoSort() {

        Graph  g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        TopologicalSort sort = new TopologicalSort();
        assertArrayEquals(new int [] {5,4,2,3,1,0}, sort.topoSort(g.v, g.adj));
    }
}