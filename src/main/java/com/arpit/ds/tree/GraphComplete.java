package com.arpit.ds.tree;

import java.util.*;

public class GraphComplete {
    public ArrayList<Integer> bfsOfGraphItr(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        if(adj != null && !adj.isEmpty()){
            boolean [] visited = new boolean[V];
            Queue<Integer> queue = new LinkedList<>();
            int start = 0;
            queue.add(start);
            while (!queue.isEmpty()){
                start = queue.poll();
                if (!visited[start]) {
                    visited[start] = true;
                    result.add(start);
                    for(Integer i : adj.get(start)){
                        queue.add(i);
                    }
                }
            }
        }
        return result;
    }

    public ArrayList<Integer> dfsOfGraphItr(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        if(adj != null && !adj.isEmpty()){
            boolean [] visited = new boolean[V];
            Stack<Integer> stack = new Stack<>();
            int start = 0;
            stack.push(start);
            while (!stack.isEmpty()){
                start = stack.pop();
                if(!visited[start]){
                    result.add(start);
                    visited[start] = true;
                }
                for(Integer i : adj.get(start)){
                    if(!visited[i]){
                        stack.push(i);
                    }
                }
            }
        }
        return result;
    }

    public ArrayList<Integer> bfsOfGraphRec(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        if(adj != null && !adj.isEmpty()){
            bfsOfGraphRec(0,adj,new boolean[V],result);
        }
        return result;
    }
    public void bfsOfGraphRec(int V, ArrayList<ArrayList<Integer>> adj,boolean [] visited,ArrayList<Integer> result ) {


    }

    public ArrayList<Integer> dfsOfGraphRec(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        if(adj != null && !adj.isEmpty()){
            dfsOfGraphRec(0,adj,new boolean[V],result);
        }
        return result;
    }
    private void dfsOfGraphRec(int V, ArrayList<ArrayList<Integer>> adj,boolean [] visited,ArrayList<Integer> result ) {
        visited[V] = true;
        result.add(V);
        for(Integer i: adj.get(V)){
            if(!visited[i]){
                dfsOfGraphRec(i,adj,visited,result);
            }
        }
    }

}
