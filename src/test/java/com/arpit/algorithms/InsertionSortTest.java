package com.arpit.algorithms;

class InsertionSortTest extends AbstractTests{
    @Override
    public SortInterface getSortImpl() {
        return new InsertionSort();
    }
}