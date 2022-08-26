package com.arpit.ds.tree;

import javax.swing.text.Element;

public class VerticalTreeTravel {
    static class Node{
        private int data, column, height;
        private Node left, right,parent;

        @Override
        public String toString() {
            return String.valueOf(data);
        }

        public int getColumn() {
            return column;
        }

        public int getHeight() {
            return height;
        }

        public Node getLeft() {
            return left;
        }

        public int getData() {
            return data;
        }

        public Node getParent() {
            return parent;
        }

        public Node getRight() {
            return right;
        }

        public Node(int data, Node parent){
            if(parent == null){
                column = 0;
                height = 0;
            }else {
                this.parent = parent;
                this.height = parent.height+1;
            }
            this.data = data;
        }
        public void setLeft(Node left) {
            if(left == null){
                return;
            }
            left.setParent(this);
            this.left = left;
            this.left.column = column -1;
        }
        public void setRight(Node right) {
            if(right == null){
                return;
            }
            right.setParent(this);
            this.right = right;
            this.right.column = column+1;
        }

        public void setParent(Node parent) {
            this.parent = parent;
            this.height = parent.height+1;

        }
    }

    public Node addElement(Node root, int data){
        if(root == null ){
            return null;
        }
        if(root.data > data){
            Node n =addElement(root.left,data);
            if(n == null) {
                root.setLeft(new Node(data, root));
            }
        }else if(root.data < data){
            Node n =addElement(root.right,data);
            if(n == null) {
                root.setRight(new Node(data, root));
            }
        }
        return root;
    }
}
