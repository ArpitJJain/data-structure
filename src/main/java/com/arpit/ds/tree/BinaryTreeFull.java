package com.arpit.ds.tree;

import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class BinaryTreeFull {

    public void inOrder(Node root, List<Integer> l) {
        if (root == null) {
            return;
        }
        inOrder(root.left,l);
        l.add(root.data);
        inOrder(root.right,l);
    }

    public void levelOrder(Node root, List<Integer> l) {
        if (root == null) {
            return;
        }

        l.add(root.data);
        if(root.left != null) {
            l.add(root.left.data);

        }
        if(root.right != null) {
            l.add(root.right.data);
        }
        levelOrder(root.right, l);
        levelOrder(root.left,l);
    }

    public void preOrder(Node root, List<Integer> l) {
        if (root == null) {
            return;
        }
        l.add(root.data);
        preOrder(root.left,l);
        preOrder(root.right,l);
    }

    public void postOrder(Node root, List<Integer> l) {
        if (root == null) {
            return;
        }
        postOrder(root.left,l);
        postOrder(root.right,l);
        l.add(root.data);
    }

    public void inOrder_NonReq(Node root, List<Integer> l) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(true){
            while(root.left != null){
                stack.push(root.left);
                root  = root.left;
            }
            root = stack.pop();
            l.add(root.data);
            if(root.right != null){
                stack.push(root.right);
                root = root.right;
            }
            if(stack.isEmpty()){
                break;
            }
        }
    }

    public void preOrder_NonReq(Node root, List<Integer> l) {
        if(root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        l.add(root.data);
        stack.push(root);



    }

    public void levelOrder_NonReq(Node root, List<Integer> l) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node n = queue.poll();
            l.add(n.data);
            if(n.left != null)
                queue.add(n.left);
            if(n.right != null)
                queue.add(n.right);
        }
    }

    public void postOrder_NonReq(Node root, List<Integer> l) {

    }


    @Test
    public void test_inOrder() {
        List<Integer> l = new ArrayList<>();
        inOrder(createTestTree(), l);
        Assertions.assertArrayEquals(new Object[]{4, 2, 5, 1, 6, 3, 7}, l.toArray());
    }

    @Test
    public void test_levelOrder() {
        List<Integer> l = new ArrayList<>();
        levelOrder(createTestTree(), l);
        Assertions.assertArrayEquals(new Object[]{4, 2, 5, 1, 6, 3, 7}, l.toArray());
    }

    @Test
    public void test_preOrder() {
        List<Integer> l = new ArrayList<>();
        preOrder(createTestTree(), l);
        Assertions.assertArrayEquals(new Object[]{1, 2, 4, 5, 3, 6, 7}, l.toArray());
    }

    @Test
    public void test_postOrder() {
        List<Integer> l = new ArrayList<>();
        postOrder(createTestTree(), l);
        Assertions.assertArrayEquals(new Object[]{4, 5, 2, 6, 7, 3,1}, l.toArray());
    }

    @Test
    public void test_inOrder_NonReq() {
        List<Integer> l = new ArrayList<>();
        inOrder_NonReq(createTestTree(), l);
        Assertions.assertArrayEquals(new Object[]{4, 2, 5, 1, 6, 3, 7}, l.toArray());
    }

    @Test
    public void test_preOrder_NonReq() {
        List<Integer> l = new ArrayList<>();
        preOrder_NonReq(createTestTree(), l);
        Assertions.assertArrayEquals(new Object[]{1, 2, 4, 5, 3, 6, 7}, l.toArray());
    }

    @Test
    public void test_postOrder_NonReq() {
        List<Integer> l = new ArrayList<>();
        postOrder_NonReq(createTestTree(), l);
        Assertions.assertArrayEquals(new Object[]{4, 5, 2, 6, 7, 3,1}, l.toArray());
    }

    private Node createTestTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    @Data
    class Node {
        public Node left, right;
        public int data;
        public Node(int data) {
            this.data = data;
        }
        public String toString() {
            return String.valueOf(data);
        }
    }
}