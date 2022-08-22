package com.arpit.ds.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class BinaryTreeTest {
    @Test
    void testCreateBT() {
        BinaryTree tree = new BinaryTree();
        BinaryTreeNode node = tree.createBT(1,2,3,4,5,6,7);
        assertEquals(1,node.getData());
    }

    @Test
    void testCreateBalancedBT() {
        BinaryTree tree = new BinaryTree();
        BinaryTreeNode root = tree.createBalancedBT(6,7,8,9,1,2,3,4,5);
        assertEquals(5,root.getData());
    }

    @Test
    void testInOrderLL() {
        BinaryTree tree = new BinaryTree();
        tree.inorderLoopStack();
    }
}