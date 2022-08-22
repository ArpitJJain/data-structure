package com.arpit.ds.tree;

import lombok.Data;

@Data
public class BinaryTreeNode {
    private BinaryTreeNode parent;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private int data;

@Override
public String toString(){
    return String.valueOf(data);
}
public BinaryTreeNode(int data){this.data=data;}
}
