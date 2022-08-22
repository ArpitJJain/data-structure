package com.arpit.algorithms;

public interface SortInterface {

    void sort(int [] data);

    default void swap(int [] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    default boolean containsData(int [] data){
        if(data == null || data.length == 0){
            return false;
        }
        return true;
    }

}
