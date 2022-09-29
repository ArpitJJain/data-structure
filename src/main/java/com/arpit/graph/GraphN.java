package com.arpit.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphN {

    private int v;
    private Map<String, List<String>> adj = new HashMap<String,List<String>>();

    public GraphN(){
        this.v = v;
    }

    public Map<String, List<String>> getGraph(){
        return this.adj;
    }

    public void addDirected(String a, String b){
        if(a != null) {
            List<String> n = adj.get(a);
            if (n == null) {
                n = new ArrayList<>();
                adj.put(a, n);
            }
            if(b!= null)
                adj.get(a).add(b);
        }
    }
    public void addNonDirected(String a, String b){
        addDirected(a,b);
        addDirected(b,a);
    }
}
