package com.arpit.ds.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {

    @Test
    void findElement() {
        Problem3 problem3 = new Problem3();
        Node n = BinaryTreeCompleteTest.getFullBinaryTree();
        assertEquals(31,problem3.findElement(n,31).val);
        assertEquals(null,problem3.findElement(n,50));

        assertEquals(31,problem3.findElementNonRecursion(n,31).val);
        assertEquals(null,problem3.findElementNonRecursion(n,50));
    }
}