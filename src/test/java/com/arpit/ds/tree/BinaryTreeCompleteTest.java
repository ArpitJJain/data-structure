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
        String retult = test.preOrderNonRecursion(root);
        assertEquals("4213657",retult);
    }

}