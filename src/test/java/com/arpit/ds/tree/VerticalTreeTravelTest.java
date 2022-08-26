package com.arpit.ds.tree;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class VerticalTreeTravelTest {

    @Test
    void addElement() {
        VerticalTreeTravel travel = new VerticalTreeTravel();
        int [] arr = new int[]{2,6,1,3,5,7};
        VerticalTreeTravel.Node root = new VerticalTreeTravel.Node(4,null);
        Arrays.stream(arr).forEach(n->{
            travel.addElement(root,n);
        });
        printTree(root,"",true);

    }
    private void printTree(VerticalTreeTravel.Node currPtr, String indent, boolean last) {
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(currPtr.getData());
            printTree(currPtr.getLeft(), indent, false);
            printTree(currPtr.getRight(), indent, true);
        }
    }
}