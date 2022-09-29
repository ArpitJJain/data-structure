package com.arpit.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class NumberNodesInBiggerGraphs {

    public static int countNumberNodesInBiggerGraphs(GraphN g){
        Set<String> visited = new HashSet<>();
        int maxCount = 0;
        for(String key : g.getGraph().keySet()){
            Stack<String> stack = new Stack<>();
            stack.push(key);
            int localCount = 0;
            boolean newTree = false;
            while (!stack.isEmpty()){
                String curr = stack.pop();
                if(!visited.contains(curr)) {
                    newTree = true;
                    visited.add(curr);
                    localCount++;
                    for (String s : g.getGraph().get(curr)) {
                        stack.push(s);
                    }
                }
            }
            maxCount = Math.max(maxCount,localCount);

        }
        return maxCount;
    }

    public static void main(String[] args) {
        GraphN g = new GraphN();
        g.addNonDirected("1","2");

        g.addNonDirected("4","6");
        g.addNonDirected("5","6");
        g.addNonDirected("7","6");
        g.addNonDirected("8","6");

        g.addNonDirected("3",null);

        System.out.println(countNumberNodesInBiggerGraphs(g));
    }
}
