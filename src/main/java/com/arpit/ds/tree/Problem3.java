package com.arpit.ds.tree;

import java.util.Stack;

public class Problem3 {
        //Give an algorithm for searching the element

    Node findElement(Node n,int element) {
        if (n == null) {
            return n;
        }
        if(n.val == element){
            return n;
        }
        Node result = findElement(n.left,element);
        if(result != null){
            return result;
        }
        result = findElement(n.right,element);
        if(result != null){
            return result;
        }
        return null;
    }

    public Node findElementNonRecursion(Node node, int element){
        Node result = null;
        if (node == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            while (node!= null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (element == node.val) {
                return  node;
            }
            node = node.right;
        }
        return result;
    }

}
