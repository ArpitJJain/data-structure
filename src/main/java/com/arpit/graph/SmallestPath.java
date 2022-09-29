package com.arpit.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SmallestPath {
    static class Meta {
        int distance;
        String node;
        public Meta(int distance, String node){
            this.distance = distance;
            this.node = node;
        }
    }

    static int smallestPath(String n1, String n2, GraphN g){
        if(n1 == null || n2 == null){
            return -1;
        }
        int mimDis = Integer.MAX_VALUE;
        Set<String> visited = new HashSet<>();

        Queue<Meta> q = new LinkedList<>();
        q.add(new Meta(0,n1));
        while(!q.isEmpty()){
            Meta curr = q.poll();
            if(!visited.contains(curr.node)) {
                visited.add(curr.node);
                if (curr.node.equals(n2)) {
                    mimDis = Math.min(mimDis, curr.distance);
                }
                for(String s : g.getGraph().get(curr.node)){
                    q.add(new Meta(curr.distance+1,s));
                }
            }
        }
        return mimDis;
    }

    public static void main(String[] args) {
        GraphN graphN = new GraphN();
        graphN.addNonDirected("w","x");
        graphN.addNonDirected("x","y");
        graphN.addNonDirected("y","z");

        graphN.addNonDirected("w","v");
        graphN.addNonDirected("v","z");

        System.out.println(smallestPath("w", "z",graphN));
        System.out.println(smallestPath("w", "y",graphN));
        System.out.println(smallestPath("w", "w",graphN));
        System.out.println(smallestPath("w", "v",graphN));
    }

}

