package com.arpit.coupa;

public class Prob1 {


    static int nCr(int n, int r)
    {
        if(r>n || n < 0){
            return 0;
        }
        if(n > 1){
            long [] fact = new long[n];
            fact[0] = 1;
            fact[1] = 2;
            for(int i = 2; i < n; i++){
                fact[i] = (fact[i-1]*(i+1))%1000000007;
            }
            return Long.valueOf(fact[n-1]/((fact[r-1] * fact[n-r-1])%1000000007)).intValue();
            //return Long.valueOf(((fact[n-1])/(fact[r-1] * fact[n-r-1]))%1000000007).intValue();
        }
        return n;

    }

    public static void main(String[] args) {
       // System.out.println(nCr(3,2));
        //System.out.println(nCr(1,1));
        System.out.println(nCr(778, 116));
    }

}
