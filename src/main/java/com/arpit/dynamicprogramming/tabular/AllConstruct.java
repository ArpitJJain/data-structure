package com.arpit.dynamicprogramming.tabular;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AllConstruct {
    public static ArrayList<ArrayList<String>> allConstructs(String target, String[] wordBank, Map<String, ArrayList<ArrayList<String>>> map) {
        ArrayList<ArrayList<String>> [] table = new ArrayList[target.length()+1];
        table[0] = new ArrayList<ArrayList<String>>();

        for(int i = 0; i < table.length; i++){
            if(table[i] != null){
                for(String word : wordBank){
                    if((i+word.length() < target.length()) && word.equals(target.substring(i, i+word.length()))){
                        ArrayList<ArrayList<String>> temp = table[i];
                        ArrayList<ArrayList<String>> val = new ArrayList<ArrayList<String>>();
                        if(temp.size() == 0){
                            ArrayList<String> a = new ArrayList<>();
                            a.add(word);
                            val.add(a);
                        }else{
                        for (ArrayList<String> l : temp ){
                            ArrayList<String> a = new ArrayList<>(l);
                            a.add(word);
                            val.add(a);
                        }
                        }
                        if(table[i+word.length()] == null){
                            table[i+word.length()] = new ArrayList<>(val);
                        }else{
                            ArrayList<ArrayList<String>> t = table[i+word.length()];
                            for(ArrayList<String> a : t){
                                for(ArrayList<String> b : val){
                                    a.addAll(b);
                                }
                            }
                        }

                    }
                }
            }
        }

        return table[target.length()];
    }

    public static void main(String[] args) {
        printArrArr(allConstructs("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd","ef","c"}, new HashMap<>()));
        printArrArr(allConstructs("skateboard", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        printArrArr(allConstructs("purple", new String[]{"purp", "p", "ur", "le", "purpl"}, new HashMap<>()));
        printArrArr(allConstructs("", new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"}, new HashMap<>()));
        printArrArr(allConstructs("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"e", "ee", "eee"}, new HashMap<>()));

    }

    private static void printArrArr(ArrayList<ArrayList<String>> val) {
        if(val!= null){
            for (ArrayList<String> v : val) {
                v.stream().forEach(s -> System.out.print(s + ", "));
                System.out.println();
            }
            System.out.println();
        }
        else{
            System.out.println("null");
        }
    }
}
