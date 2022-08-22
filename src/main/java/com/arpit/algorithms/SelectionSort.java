package com.arpit.algorithms;

public class SelectionSort implements SortInterface{
    @Override
    public void sort(int[] data) {
        if (containsData(data)) {
            for (int i = 0; i < data.length; i++) {
                int minData = data[i];
                int minIndex = i;
                for (int j = i; j < data.length; j++) {
                    if (minData > data[j]) {
                        minData = data[j];
                        minIndex = j;
                    }
                }
                if (i != minIndex) {
                    swap(data,i,minIndex);
                }
            }
        }
    }
}