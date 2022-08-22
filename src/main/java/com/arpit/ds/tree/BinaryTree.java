package com.arpit.ds.tree;

import java.util.*;

public class BinaryTree {

    public BinaryTreeNode createBT(int... elements) {
        BinaryTreeNode root = new BinaryTreeNode(elements[0]);
        for (int i = 1; i < elements.length; i++) {
            root = addElement(root, elements[i]);
        }
        return root;
    }

    private BinaryTreeNode addElement(BinaryTreeNode node, int data) {
        if (node == null) {
            node = new BinaryTreeNode(data);
            return node;
        }
        if (data < node.getData()) {
            node.setLeft(addElement(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(addElement(node.getRight(), data));
        }
        return node;
    }

    public BinaryTreeNode createBalancedBT(int... elements) {
        // Create a Primary Binary Tree
        BinaryTreeNode root = createBT(elements);
        //Get Sorted Array in Order
        List<BinaryTreeNode> list = new ArrayList<>();
        inorder(list, root);
        list.forEach(System.out::println);

        //get Balanced Tree
        root = addElementToBalancedTree(list, 0, list.size() - 1);

        return root;
    }

    private BinaryTreeNode addElementToBalancedTree(List<BinaryTreeNode> list, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return null;
        int mid = (endIndex + startIndex) / 2;
        BinaryTreeNode root = list.get(mid);
        root.setLeft(addElementToBalancedTree(list, startIndex, mid - 1));
        root.setRight(addElementToBalancedTree(list, mid + 1, endIndex));
        return root;
    }

    private void inorder(List<BinaryTreeNode> list, BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        inorder(list, root.getLeft());
        list.add(root);
        inorder(list, root.getRight());
    }

    

    public void inorderLoopStack() {
        BinaryTreeNode root = getTempTree();
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (root!= null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            System.out.println(root.getData());
            root = root.getRight();
        }
    }

    public void inorderLoopNoStack() {
        BinaryTreeNode root = getTempTree();
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (root!= null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            System.out.println(root.getData());
            root = root.getRight();
        }
    }

    private static BinaryTreeNode getTempTree() {
        BinaryTreeNode root = new BinaryTreeNode(4);

        root.setRight(new BinaryTreeNode(6));
        root.setLeft(new BinaryTreeNode(2));


        root.getLeft().setLeft(new BinaryTreeNode(1));
        root.getLeft().setRight(new BinaryTreeNode(3));

        root.getRight().setLeft(new BinaryTreeNode(5));
        root.getRight().setRight(new BinaryTreeNode(7));

        return root;
    }
}

