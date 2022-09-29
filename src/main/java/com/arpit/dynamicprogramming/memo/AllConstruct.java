package com.arpit.dynamicprogramming.memo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AllConstruct {
    public static ArrayList<ArrayList<String>> allConstructs(String target, String[] wordBank, Map<String, ArrayList<ArrayList<String>>> map) {
        if(map.containsKey(target)){
            return map.get(target);
        }
        if(target == null){
            return null;
        }
        if(target.length() == 0){
            return new ArrayList<ArrayList<String>>();
        }
        ArrayList<ArrayList<String>> r = null;
        for(String s : wordBank){
            if(target.startsWith(s)){
                ArrayList<ArrayList<String>> returnVal = allConstructs(target.replaceFirst(s,""),wordBank,map);
                if(returnVal != null) {
                    if(r == null)
                        r = new ArrayList<>();
                    if(returnVal.size() == 0){
                        ArrayList<String> e = new ArrayList<String>();
                        e.add(s);
                        r.add(e);
                    }else {
                        for (ArrayList<String> a : returnVal) {
                            ArrayList<String> e = new ArrayList<String>();
                            e.add(s);
                            e.addAll(a);
                            r.add(e);
                        }
                    }
                }
            }
        }
        map.put(target,r);
        return r;
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
