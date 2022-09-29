import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.stream.IntStream;


class Solution {
    public long[] optimalArray(int n,int a[])
    {
        Map<String, Long> memo = new HashMap<>();
        long [] result = new long[a.length];
        result[0] = 0;
        for(int i = 1; i<a.length; i++){
            long midPoint = getMidPoint( 0,  i, a);
            result[i] = result[i-1]+Math.abs(midPoint-a[i]);
        }
        return result;
    }


    public long getMidPoint(int start, int end, int[] a){

        Map map = null;
        new ArrayList<>(map.values());
        long m=0;
        int n = end+1-start;
        m=a[((n+1)/2)-1];
        return m;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
       Arrays.stream(s.optimalArray(4,new int[]{1,6,9,12})).forEach(System.out::println);
        System.out.println("--------------------------------");
        Arrays.stream(s.optimalArray(7,new int[]{1,1,1,7,7,10,19})).forEach(System.out::println);
    }
}