package com.arpit;


//import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static ArrayList<Integer> downwardDigonal(int N, int A[][])
    {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        int i =0, j =0;

        while(j< N){
            add(i,j,result,A,N);
            j++;
        }
        j--;
        i++;
        while(i < N){
            add(i,j,result,A,N);
            i++;
        }
        return result;
    }
    static void add(int i, int j,ArrayList<Integer> result, int A[][],int N){
        int a = i;
        int b = j;
        while ( a >=0 && b >= 0 && a < N && b <N){
            result.add(A[a][b]);
            a++;
            b--;
            /*if(a == j && b == i){
                break;
            }*/
        }
    }

    public static void main(String[] args) {
        downwardDigonal(2,new int[][]{{1, 2},{3, 4}}).stream().forEach(s-> System.out.print(s+" "));
        System.out.println();

        downwardDigonal(3,new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}}).stream().forEach(s-> System.out.print(s+" "));
        System.out.println();

        downwardDigonal(3,new int[][]{
                {25,79,59},
                {63,65,6},
                {46,82,28}}).stream().forEach(s-> System.out.print(s+" "));
        System.out.println();
    }
}