package com.sortvisualizer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SelectionSortAnimation implements Animation{
    @Getter
    private int firstIndexToCompare;
    @Getter
    private int secondIndexToCompare;
    @Getter
    private int leftValueToSwap;
    @Getter
    private int rightValueToSwap;
}
