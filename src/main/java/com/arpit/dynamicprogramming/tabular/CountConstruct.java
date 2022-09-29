package com.arpit.dynamicprogramming.tabular;

import java.util.HashMap;

public class CountConstruct {
    public static long countConstruct(String target, String [] dict){
        long [] cache = new long[target.length()+1];
        cache[0] = 1;
        for(int i = 0; i<cache.length; i++){
            if(cache[i] > 0){
                for(String word : dict){
                    if(target.length() >= i+word.length() && target.substring(i,i+word.length()).equals(word)){
                        cache[i+word.length()] = cache[i+word.length()] +cache[i];
                    }
                }
            }
        }

        return cache[target.length()];
    }

    public static void main(String[] args) {
        System.out.println(countConstruct("abcdef",new String[]{"ab","abc","cd","def","abcd","ef"}));
        System.out.println(countConstruct("skateboard",new String[]{"bo","rd","ate","t","ska","sk","boar"}));
        System.out.println(countConstruct("purple",new String[]{"purp","p","ur","le","purpl"}));
        System.out.println(countConstruct("",new String[]{"bo","rd","ate","t","ska","sk","boar"}));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",new String[]{"e","ee","eee"}));

    }
}
