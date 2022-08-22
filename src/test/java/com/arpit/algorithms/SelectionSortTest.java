package com.arpit.algorithms;

class SelectionSortTest extends AbstractTests{
    @Override
    public SortInterface getSortImpl() {
        return new SelectionSort();
    }
}