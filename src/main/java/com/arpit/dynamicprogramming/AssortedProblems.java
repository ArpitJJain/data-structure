package com.arpit.dynamicprogramming;


import java.util.Arrays;

public class AssortedProblems {

    /*
     * Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
     * The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By convention, 1 is included.
     * Given a number n, the task is to find n’th Ugly number.
     */
    public int nthUglyNumber(int n){

       return n;
    }

    private int uglyNumber(int n,){



        return 0;
    }
    public static boolean check(long A[],long B[],int N)
    {
        if(A==null && B==null){
            return true;
        }else
        if((A== null && B != null) || ( A!= null && B== null) || (A.length != B.length)){
            return false;
        }

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i =0; i < A.length; i++) {
            if(A[i] != B[i]){
                return false;
            }
        }
        return true;
    }
        //Your code here
    }



}
