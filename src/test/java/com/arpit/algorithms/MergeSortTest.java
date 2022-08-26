package com.arpit.algorithms;

class MergeSortTest extends AbstractTests{
    @Override
    public SortInterface getSortImpl() {
        return new MergeSort();
    }
}