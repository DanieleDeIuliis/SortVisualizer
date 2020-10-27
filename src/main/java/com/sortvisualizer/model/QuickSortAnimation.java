package com.sortvisualizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
public class QuickSortAnimation implements Animation{

    @Getter
    private int firstIndexToCompare;
    @Getter
    private int secondIndexToCompare;
    @Getter
    private int leftValueToSwap;
    @Getter
    private int rightValueToSwap;
    @Getter
    private int pivot;
}
