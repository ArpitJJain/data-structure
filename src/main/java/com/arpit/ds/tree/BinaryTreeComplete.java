package com.arpit.ds.tree;

import java.util.Stack;

class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val = val;
    }
}

public class BinaryTreeComplete {

    public String preOrderRecursion(Node root){
            StringBuilder sb = new StringBuilder();
            preOrderRe(root,sb);
            return sb.toString();
    }
    public void preOrderRe(Node root,StringBuilder sb){
        if(root == null){
            return;
        }
        sb.append(root.val);
        preOrderRe(root.left,sb);
        preOrderRe(root.right,sb);
    }

    public String inOrder(Node root){
        if(root == null){
            return  "";
        }
        StringBuilder sb = new StringBuilder();
        inOrder(root,sb);
        return sb.toString();
    }
    public void inOrder(Node root,StringBuilder sb){
        if(root == null){
            return;
        }
        inOrder(root.left,sb);
        sb.append(root.val).append(",");
        inOrder(root.right,sb);
    }


    public String preOrderNonRecursion(Node root) {
            StringBuilder sb = new StringBuilder();
            preOrderRe(root,sb);
            return sb.toString();
    }

    public void preOrder(Node root,StringBuilder sb){
        if(root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        while(true){
            while(root != null){
                sb.append(root.val);
                stack.push(root);
                root = root.left;
            }
            if(stack.isEmpty()){
                break;
            }
            root = stack.pop().right;
        }
    }
}
