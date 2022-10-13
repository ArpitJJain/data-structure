package com.arpit.dynamicprogramming;

public class LexicographicallySmallest {
    static String lexicographicallySmallest(String S, int k) {
        int len = S.length();
        int rem = -1;
        while(len > 1){
            rem = len%2;
            len = len /2;
        }
        if(rem == 0){
            k = k/2;
        }else {
            k = k*2;
        }
        return ""+k;
    }

    public static void main(String[] args) {
        System.out.println(lexicographicallySmallest("fooland",2));
    }
}
