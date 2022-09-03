package com.arpit.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeComplete {

    public String preOrderRecursion(Node root) {
        StringBuilder sb = new StringBuilder();
        preOrderRe(root, sb);
        return sb.toString();
    }

    public void preOrderRe(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        preOrderRe(root.left, sb);
        preOrderRe(root.right, sb);
    }

    public String inOrderRecursion(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        inOrderRecursion(root, sb);
        return sb.toString();
    }

    public void inOrderRecursion(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        inOrderRecursion(root.left, sb);
        sb.append(root.val).append(",");
        inOrderRecursion(root.right, sb);
    }

    public String inOrderNonRecursion(Node root){
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Stack<Node> s = new Stack();
        while(true){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            if(s.isEmpty()){
                break;
            }
            root = s.pop();
            sb.append(root.val).append(",");
            root = root.right;
        }
        return sb.toString();

    }

    public int height(Node node) {
        return height(node, 1) - 1;
    }

    int height(Node node, int height) {
        if (node == null) {
            return height;
        }

        int leftH = height(node.left, height);
        int rightH = height(node.right, height);

        return leftH > rightH ? leftH + height : rightH + height;
    }


    public String preOrderNonRecursion(Node root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        return sb.toString();
    }

    public void preOrder1(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                sb.append(root.val);
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop().right;
        }
    }

    public void preOrder(Node root, StringBuilder sb) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            if (n != null) {
                sb.append(n.val);
                stack.push(n.right);
                stack.push(n.left);
            }
        }

    }

    public void levelOrderNonReq (Node root, StringBuilder sb){
        if(root == null){
            return ;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            sb.append(root.val).append(",");
            if(root.left != null){
                queue.add(root.left);
            }
            if(root.right != null){
                queue.add(root.right);
            }
        }
    }
}