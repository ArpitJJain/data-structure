package com.arpit.dynamicprogramming.tabular;

public class GridTraveller {
    static long gridTraveller(int m, int n) {
        long[][] tab = new long[m+1][n+1];
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 && n == 1) {
            return 1;
        }
        tab[1][1] = 1;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                long curr = tab[i][j];
                if (j + 1 <= n)
                    tab[i][j + 1] += curr;
                if (i + 1 <= m)
                    tab[i + 1][j] += curr;

            }
        }
        return tab[m][n];
    }

    public static void main(String[] args) {
        System.out.println(gridTraveller(1, 1));
        System.out.println(gridTraveller(2, 3));
        System.out.println(gridTraveller(3, 2));
        System.out.println(gridTraveller(3, 3));
        System.out.println(gridTraveller(18, 18));
    }
}
