package com.arpit.dynamicprogramming;


import java.util.Arrays;
import java.util.HashMap;

public class CoinChanges {

    /*
    Given an integer  array coins[ ] of size N representing different denominations of currency and an integer sum,
    find the number of ways you can make sum by using different combinations from coins[ ].
        Example 1:

        Input:
        sum = 4 ,
        N = 3
        coins[] = {1,2,3}
        Output: 4
        Explanation: Four Possible ways are:
        {1,1,1,1},{1,1,2},{2,2},{1,3}.


        Example 2:
        Input:
        Sum = 10 ,
        N = 4
        coins[] ={2,5,3,6}
        Output: 5;
        Explanation: Five Possible ways are:
        {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5}
        and {5,5}.
     */
    public long count(int coins[], int N, int sum) {
        HashMap<String, Long> map = new HashMap<>();
        Arrays.sort(coins);
        return count(coins, coins.length -1, sum,map);
    }

    private long count(int[] coins, int end, int sum, HashMap<String, Long> map) {
        String key = end+"_"+sum;
        System.out.println(key);
        Long i = map.get(key);
        if(i != null){
            return i;
        }
        long returnVal;
        if(sum == 0){
            return 1;
        }else if(sum<0 || end <0){
            return 0;
        }else if (sum < coins[end]){
            returnVal =count(coins,sum,end-1,map);
        }else {
            returnVal =count(coins, end - 1, sum - coins[end], map) +
                    count(coins, end-1, sum, map);
        }
        map.put(key,returnVal);
        return returnVal;
    }
}
