package com.arpit.algorithms;

class BubbleSortTest extends AbstractTests{
    @Override
    public SortInterface getSortImpl() {
        return new BubbleSort();
    }
}