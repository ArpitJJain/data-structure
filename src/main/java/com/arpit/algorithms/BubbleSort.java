package com.arpit.algorithms;

public class BubbleSort implements SortInterface{
    @Override
    public void sort(int[] data) {
       if(containsData(data)) {
           for (int i = 0; i < data.length; i++) {
               for (int j = i; j < data.length; j++) {
                   if (data[i] > data[j]) {
                       swap(data, i, j);
                   }
               }
           }
       }
    }
}
