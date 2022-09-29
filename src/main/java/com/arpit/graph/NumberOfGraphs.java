package com.arpit.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class NumberOfGraphs {

    public static int countGraphs(GraphN g){
        Set<String> visited = new HashSet<>();
        int count = 0;
        for(String key : g.getGraph().keySet()){
            Stack<String> stack = new Stack<>();
            stack.push(key);
            boolean newTree = false;
            while (!stack.isEmpty()){
                String curr = stack.pop();
                if(!visited.contains(curr)) {
                    newTree = true;
                    visited.add(curr);
                    for (String s : g.getGraph().get(curr)) {
                        stack.push(s);
                    }
                }
            }
            if(newTree){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        GraphN g = new GraphN();
        g.addNonDirected("1","2");

        g.addNonDirected("4","6");
        g.addNonDirected("5","6");
        g.addNonDirected("7","6");
        g.addNonDirected("8","6");

        g.addNonDirected("3",null);

        System.out.println(countGraphs(g));
    }
}
