package com.arpit.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class StepCounter {

    /**
     *
     * Person can move 1 step or 2 steps in one time. if we are give a steps count, how many ways a
     * person can count that
     *
     */
    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<>());
    }

    private int climbStairs(int n, Map<Integer, Integer> map){
        if(map.containsKey(n)){
            return map.get(n);
        }
        if(n <= 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }
        int result = climbStairs(n -1,map)+climbStairs(n -1,map);
        map.put(n,result);
        return result;
    }
}
