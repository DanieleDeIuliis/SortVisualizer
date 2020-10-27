package com.sortvisualizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
public class MergeSortAnimation implements Animation{

    @Getter
    private int firstIndexToCompare;
    @Getter
    private int secondIndexToCompare;
    @Getter
    private int indexToMove;
    @Getter
    private int valueToSet;
}
