package com.arpit.dynamicprogramming;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
class Person{
    String name;
    int age;
}
public class MinimumJumps  implements Comparable{

    Comparator<String> c = (a,b)->a.compareTo(b);

    Comparator<Person> name = (a,b) -> a.name.compareTo(b.name);
    Comparator<Person> age = (a,b) -> Integer.valueOf(a.age).compareTo(b.age);
    static int minJumps(int[] arr){
        return minJumps(arr,0,new HashMap<>());
    }
    static int minJumps(int[] arr, int pos, Map<Integer, Integer> map){
        if(map.containsKey(pos)){
            return map.get(pos);
        }
        if(pos >= arr.length -1){
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr[pos]; i++){
            if(arr[pos+i] ==0){
                map.put(pos+i,-1);
                return -1;
            }
            int val = minJumps(arr,pos+i,map);
            if(val != -1){
                min = Math.min(min,val);
            }
        }
        map.put(pos,min);
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9} ));
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
