package com.arpit.graph;

import java.util.List;
import java.util.Stack;

public class CheckPath {
    public static boolean checkPath(String n1, String n2, GraphN g){
        Stack<String> stack = new Stack<>();
        stack.push(n1);
        while (!stack.isEmpty()){
            String curr  = stack.pop();
            if(curr.equals(n2)){
                return true;
            }
            List<String> list = g.getGraph().get(curr);
            if(list!= null) {
                for (String a :list) {
                    stack.push(a);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        GraphN g = new GraphN();
        g.addDirected("f","g");
        g.addDirected("f","i");
        g.addDirected("g","h");
        g.addDirected("g","i");
        g.addDirected("i","g");
        g.addDirected("i","k");

        System.out.println(checkPath("j","f",g));
        System.out.println(checkPath("f","k",g));
    }
}
