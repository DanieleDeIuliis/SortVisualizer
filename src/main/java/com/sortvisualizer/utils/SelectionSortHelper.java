package com.sortvisualizer.utils;

import com.sortvisualizer.model.Animation;
import com.sortvisualizer.model.SelectionSortAnimation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SelectionSortHelper implements SortHelper{

    @Override
    public List<Animation> sort(List<Integer> arrayToSort) {
        List<Animation> animations = new ArrayList<>();
        int nextIndexToSort = 0;
        while(nextIndexToSort < arrayToSort.size()) {
            swapElements(arrayToSort, nextIndexToSort, animations);
            nextIndexToSort++;
        }
        return animations;
    }

    private void swapElements(List<Integer> arrayToSort, int nextIndexToSort,
                              List<Animation> animations) {
        int minIndex = findMinIndex(arrayToSort, nextIndexToSort);
        int currentMinValue = arrayToSort.get(minIndex);
        animations.add(new SelectionSortAnimation(nextIndexToSort, minIndex,
                arrayToSort.get(nextIndexToSort), currentMinValue));
        arrayToSort.set(minIndex, arrayToSort.get(nextIndexToSort));
        arrayToSort.set(nextIndexToSort, currentMinValue);
    }

    private int findMinIndex(List<Integer> arrayToSort, int nextIndexToSort) {
        int min = Integer.MAX_VALUE;
        int minIndex = nextIndexToSort;
        for(int i = nextIndexToSort; i < arrayToSort.size(); i++) {
            if(arrayToSort.get(i) <= min) {
                min = arrayToSort.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }
}
