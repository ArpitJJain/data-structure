package com.arpit.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class PrefixCount {
    static List<Integer> prefixCount(int N, int Q, String li[], String query[])
    {
        List<Integer> result = new ArrayList<>();
        TrieNode node = new TrieNode();

        for(String l : li){
            char [] chars = l.toCharArray();
            TrieNode t = node;
            for(int i = 0; i < chars.length; i++){
                int ind = chars[i]-97;
                TrieNode temp = t.arr[ind];
                if(temp == null){
                    t.arr[ind] = new TrieNode();
                    temp = t.arr[ind];
                }
                temp.count++;
                t = temp;
                if(i == chars.length-1){
                    t.isLastWord = true;
                }
            }
        }

        for(String q : query){
            char [] chars = q.toCharArray();
            TrieNode t = null;
            TrieNode temp = node;
            for(char c : chars){
                int ind = c-97;
                t = temp.arr[ind];
                if(t == null){
                    break;
                }
                temp = t;
            }
            if(t != null){
                result.add(t.count);
            }else{
                result.add(0);
            }
        }
        return result;
    }

    static class TrieNode{
        TrieNode [] arr;
        boolean isLastWord;

        int count =0;
        public TrieNode(){
            this.arr = new TrieNode [26];
            this.isLastWord = false;
        }
    }

    public static void main(String[] args) {
        prefixCount(0,0,new String[]{"abracadabra", "geeksforgeeks",
                "abracadabra", "geeks", "geeksthrill"},new String[]{"abr", "geeks", "geeksforgeeks",
                "ge", "gar"}).stream().forEach(System.out::println);
    }
}
