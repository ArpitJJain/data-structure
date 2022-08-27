package com.arpit.ds.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class Problem1Test {

    @Test
    void findMax() {
        Problem1 problem1 = new Problem1();
        Node node = BinaryTreeCompleteTest.getFullBinaryTree();
        assertEquals(31, problem1.findMax(node));
        assertEquals(31, problem1.findMaxNoRecursion(node));
    }
}