package com.sortvisualizer.utils;

import com.sortvisualizer.model.Animation;
import com.sortvisualizer.model.SelectionSortAnimation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SelectionSortHelper implements SortHelper{

    @Override
    public List<Animation> sort(List<Integer> numbersToSort) {
        List<Animation> animations = new ArrayList<>();
        int nextIndexToSort = 0;
        while(nextIndexToSort < numbersToSort.size()) {
            swapElements(numbersToSort, nextIndexToSort, animations);
            nextIndexToSort++;
        }
        return animations;
    }

    private void swapElements(List<Integer> numbersToSort, int nextIndexToSort,
                              List<Animation> animations) {
        int minIndex = findMinIndex(numbersToSort, nextIndexToSort);
        int currentMinValue = numbersToSort.get(minIndex);
        animations.add(new SelectionSortAnimation(nextIndexToSort, minIndex,
                numbersToSort.get(nextIndexToSort), currentMinValue));
        numbersToSort.set(minIndex, numbersToSort.get(nextIndexToSort));
        numbersToSort.set(nextIndexToSort, currentMinValue);
    }

    private int findMinIndex(List<Integer> numbersToSort, int nextIndexToSort) {
        int min = Integer.MAX_VALUE;
        int minIndex = nextIndexToSort;
        for(int i = nextIndexToSort; i < numbersToSort.size(); i++) {
            if(numbersToSort.get(i) <= min) {
                min = numbersToSort.get(i);
                minIndex = i;
            }
        }
        return minIndex;
    }
}
