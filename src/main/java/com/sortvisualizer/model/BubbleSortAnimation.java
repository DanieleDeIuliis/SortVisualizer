package com.sortvisualizer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class BubbleSortAnimation implements Animation {
    @Getter
    private final int firstIndexToCompare;
    @Getter
    private final int secondIndexToCompare;
    @Getter
    private final int leftValueToSwap;
    @Getter
    private final int rightValueToSwap;
}
