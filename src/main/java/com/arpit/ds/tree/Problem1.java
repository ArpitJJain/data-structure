package com.arpit.ds.tree;

import com.arpit.ds.tree.Node;

import java.util.Stack;

public class Problem1 {

    //Give an algorithm for finding maximum element in the binary tree.
    int findMax(Node n) {
        if (n == null) {
            return Integer.MIN_VALUE;
        }
        int currVal = n.val;
        int leftMax = findMax(n.left);
        int rightMax = findMax(n.right);
        return Math.max(Math.max(currVal, leftMax), rightMax);
    }

    int findMaxNoRecursion(Node node) {
        int max = Integer.MIN_VALUE;
        if (node == null) {
            return max;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            while (node!= null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (max < node.val) {
                max = node.val;
            }
            node = node.right;
        }
        return max;
    }
}
