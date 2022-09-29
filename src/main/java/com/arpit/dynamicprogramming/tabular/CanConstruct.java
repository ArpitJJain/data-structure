package com.arpit.dynamicprogramming.tabular;

import java.util.HashMap;

public class CanConstruct {
    public static boolean canConstruct(String target, String [] dict){
        boolean [] cache = new boolean[target.length()+1];
        cache[0] = true;
        for(int i = 0; i<cache.length; i++){
            if(cache[i] == true){
                for(String word : dict){
                    if(target.length() >= i+word.length() && target.substring(i,i+word.length()) == word){
                        cache[i+word.length()] = true;
                    }
                }
            }
        }

        return cache[target.length()];
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef",new String[]{"ab","abc","cd","def","abcd"}));
        System.out.println(canConstruct("skateboard",new String[]{"bo","rd","ate","t","ska","sk","boar"}));
        System.out.println(canConstruct("",new String[]{"bo","rd","ate","t","ska","sk","boar"}));
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[]{"e","ee","eee"}));

    }
}
