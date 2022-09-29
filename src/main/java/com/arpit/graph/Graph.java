package com.arpit.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private int v;
    private List<List<Integer>> adj = new ArrayList<List<Integer>>();

    public Graph(int v){
        this.v = v;
        for(int i = 0; i<v; i++){
            adj.add(new ArrayList<Integer>());
        }
    }

    public List<List<Integer>> getGraph(){
        return this.adj;
    }

    public void addDependency(int a, int b){
        if(a>v || b > v ){
            return;
        }
        adj.get(a).add(b);
    }

}