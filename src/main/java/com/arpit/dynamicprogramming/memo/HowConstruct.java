package com.arpit.dynamicprogramming.memo;

public class HowConstruct {
    public static boolean canConstruct(String target, String [] wordBank){
        if(target == null){
            return false;
        }
        if(target.length() == 0){
            return true;
        }
        for(String s : wordBank){
            if(target.startsWith(s)){
                if(canConstruct(target.replaceFirst(s,""),wordBank))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef",new String[]{"ab","abc","cd","def","abcd"}));
        System.out.println(canConstruct("skateboard",new String[]{"bo","rd","ate","t","ska","sk"}));
    }
}
