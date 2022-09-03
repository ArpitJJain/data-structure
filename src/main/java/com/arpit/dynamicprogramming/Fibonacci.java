package com.arpit.dynamicprogramming;


import java.math.BigInteger;

public class Fibonacci {

    public long nthFibonacci(long n){
        int l = (int)n;
        if(n <= 1){
            return n;
        }


        BigInteger[] fib = new BigInteger [l+1];
        fib[0]=new BigInteger("0");
        fib[1]=new BigInteger("1");

        for(int i = 2; i <=l; i++){
            fib[i] = fib[i-1].add(fib[i-2]);
            System.out.println(fib[i-2] +" + "+fib[i-1]+" = "+fib[i]);
        }

        return fib[l].longValue();
    }
}
