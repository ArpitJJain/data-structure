package com.arpit;

public class NearestPrime {
    public int NthTerm(int N)
    {
        // code here
        int i = N, j = N;

        while(!isPrime(i)){
            i--;
        }
        while(!isPrime(j)){
            j++;
        }
        return Math.min(N-i,j-N);
    }

    public boolean isPrime(int n){
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }




}
