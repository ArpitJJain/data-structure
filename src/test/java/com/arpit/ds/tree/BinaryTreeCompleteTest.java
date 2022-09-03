package com.arpit.ds.tree;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeCompleteTest {

    @Test
    public void test_preOrderRecursion(){
        BinaryTreeComplete test = new BinaryTreeComplete();
        /*
        * Input Tree Type
        *                4
        *             /     \
        *            2       6
        *          /   \    /   \
        *         1    3   5     7
        *
        * Output after Pre Order = 4,2,1,3,6,5,7
        * */

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        String retult = test.preOrderRecursion(root);
        assertEquals("4213657",retult);
    }

    @Test
    public void test_preOrderNonRecursion(){
        BinaryTreeComplete test = new BinaryTreeComplete();

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        String result = test.preOrderNonRecursion(root);
        assertEquals("4213657",result);
    }

    @Test
    public void test_inOrder(){
        BinaryTreeComplete test = new BinaryTreeComplete();
        Node root = getFullBinaryTree();
        String result = test.inOrderRecursion(root);
        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,",result);
    }

    @Test
    public void test_inOrderNonRecurtion(){
        BinaryTreeComplete test = new BinaryTreeComplete();
        Node root = getFullBinaryTree();
        String result = test.inOrderNonRecursion(root);
        assertEquals("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,",result);
    }

    public static Node getFullBinaryTree(){

        /*
         * Input Tree Type
         *                                 16
         *                          /             \
         *                        /                 \
         *                      /                     \
         *                    /                         \
         *                   8                            24
         *              /        \                   /          \
         *            /           \                 /            \
         *         4               12             20               28
         *     /      \         /     \         /     \         /     \
         *    2        6      10      14      18      22      26      30
         *  /  \     /  \    /  \    /  \    /  \    /  \    /  \    /  \
         * 1    3   5   7   9   11  13  15  17  19  21  23  25  27  29  31
         *
         *
         * */

        Node n = new Node(16);
        n.left = new Node(8);
        n.left.left = new Node(4);
        n.left.right = new Node(12);
        n.left.left.left = new Node(2);
        n.left.left.right = new Node(6);
        n.left.right.left = new Node(10);
        n.left.right.right = new Node(14);
        n.left.left.left.left = new Node(1);
        n.left.left.left.right = new Node(3);
        n.left.left.right.left = new Node(5);
        n.left.left.right.right = new Node(7);
        n.left.right.left.left = new Node(9);
        n.left.right.left.right = new Node(11);
        n.left.right.right.left = new Node(13);
        n.left.right.right.right = new Node(15);
        n.right = new Node(24);
        n.right.left = new Node(20);
        n.right.right = new Node(28);
        n.right.left.left = new Node(18);
        n.right.left.right = new Node(22);
        n.right.right.left = new Node(26);
        n.right.right.right = new Node(30);
        n.right.left.left.left = new Node(17);
        n.right.left.left.right = new Node(19);
        n.right.left.right.left = new Node(21);
        n.right.left.right.right = new Node(23);
        n.right.right.left.left = new Node(25);
        n.right.right.left.right = new Node(27);
        n.right.right.right.left = new Node(29);
        n.right.right.right.right = new Node(31);
        return n;
    }

    @Test
    void test_height() {
        Node n = new Node(2);
        n.right = new Node(3);
        n.left = new Node(1);
        BinaryTreeComplete binaryTree = new BinaryTreeComplete();
        assertEquals(2,binaryTree.height(n));
        assertEquals(5,binaryTree.height(getFullBinaryTree()));
    }

    @Test
    void preOrderRecursion() {
    }

    @Test
    void preOrderRe() {
    }

    @Test
    void inOrderRecursion() {
    }

    @Test
    void testInOrderRecursion() {
    }

    @Test
    void inOrderNonRecursion() {
    }

    @Test
    void height() {
    }

    @Test
    void testHeight() {
    }

    @Test
    void preOrderNonRecursion() {
    }

    @Test
    void preOrder1() {
    }

    @Test
    void preOrder() {
    }

    @Test
    void levelOrderNonReq() {
        String result = "16,8,24,4,12,20,28,2,6,10,14,18,22,26,30,1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,";
        BinaryTreeComplete bt = new BinaryTreeComplete();
        StringBuilder sb = new StringBuilder();
        bt.levelOrderNonReq(getFullBinaryTree(),sb);
        assertEquals(result,sb.toString());
    }
}