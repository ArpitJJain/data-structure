package com.arpit.ds.tree;


public class AVLTree {
    Node root;

    // Driver code
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        /*tree.root = tree.insertNode(tree.root, 33);
        tree.root = tree.insertNode(tree.root, 13);
        tree.root = tree.insertNode(tree.root, 53);
        tree.root = tree.insertNode(tree.root, 9);
        tree.root = tree.insertNode(tree.root, 21);
        tree.root = tree.insertNode(tree.root, 61);
        tree.root = tree.insertNode(tree.root, 8);
        tree.root = tree.insertNode(tree.root, 11);
        tree.printTree(tree.root, "", true);
        tree.root = tree.deleteNode(tree.root, 13);*/

        tree.root = tree.new Node(4);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(6);
        tree.root.left.left = tree.new Node(1);
        tree.root.left.right = tree.new Node(3);
        tree.root.right.left = tree.new Node(5);
        tree.root.right.right = tree.new Node(7);

        tree.printTree(tree.root, "", true);
    }

    void insertNode(Node n){
        if(root == null){
            root = n;
            return;
        }

        
    }


    int newHeight(Node node) {
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return (leftHeight > rightHeight ? leftHeight : rightHeight) + 1;
    }

    int height(Node node) {
        return node == null ? 0 : node.height;

    }

    int getBalanceFactor(Node node){
        if (node ==null){
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Print the tree
    private void printTree(Node currPtr, String indent, boolean last) {
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(currPtr.data);
            printTree(currPtr.left, indent, false);
            printTree(currPtr.right, indent, true);
        }
    }

    class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }
}