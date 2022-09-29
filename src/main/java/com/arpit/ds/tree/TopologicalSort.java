package com.arpit.ds.tree;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public int[] topoSort_old(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> stack = new Stack<>();
        boolean [] visited = new boolean [V];
        int [] result = new int [V];
        for(int i = 0; i < adj.size(); i++ ){
            if(!visited[i]) {
                dfs_old(i,visited,adj,stack);
            }
        }

        int i =0;
        while (!stack.empty())
            result[i++] = stack.pop();
        return result;
    }
    public void dfs_old(int v,boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack){
        visited[v] = true;
        for(int i = 0; i < adj.get(v).size(); i++){
            if(!visited[adj.get(v).get(i)]){
                dfs_old(adj.get(v).get(i),visited,adj,stack);
            }
        }


    }
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> stack = new Stack<>();
        boolean [] visited = new boolean [V];
        int [] result = new int [V];
        for (int i = 0; i< adj.size(); i++){
            if(!visited[i]){
                dfs(i,adj,stack,visited);
            }
        }
        int i =0;
        while (!stack.empty())
            result[i++] = stack.pop();
        return result;
    }
    public void dfs(int V, ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack,boolean [] visited){
        visited[V] = true;
        for(int i = 0; i< adj.get(V).size(); i++){
            if(!visited[adj.get(V).get(i)]) {
                dfs(adj.get(V).get(i), adj, stack, visited);
            }
        }
        stack.push(V);
    }
}