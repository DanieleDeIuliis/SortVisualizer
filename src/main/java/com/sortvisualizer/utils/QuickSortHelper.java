package com.sortvisualizer.utils;

import com.sortvisualizer.model.Animation;
import com.sortvisualizer.model.QuickSortAnimation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class QuickSortHelper implements SortHelper {


    @Override
    public List<Animation> sort(List<Integer> numbersToSort) {
        List<Animation> animations = new ArrayList<Animation>();
        quickSort(numbersToSort, animations, 0, numbersToSort.size() - 1);
        return animations;
    }

    public void quickSort(List<Integer> toSort, List<Animation> animations,
                     int leftIndex, int rightIndex) {
        int index = partitionArray(toSort, animations, leftIndex, rightIndex);
        // indexToCheck -1 because the returned index is always one greater than the left part to sort
        Predicate<Integer> leftIndexLessThanIndex = indexToCheck -> leftIndex < indexToCheck -1;
        Predicate<Integer> indexLessThanRightIndex = indexToCheck -> rightIndex > indexToCheck;
        if(leftIndexLessThanIndex.test(index)) {
            quickSort(toSort, animations, leftIndex, index - 1);
        }

        if(indexLessThanRightIndex.test(index)) {
            quickSort(toSort, animations, index, rightIndex);
        }
    }

    private int partitionArray(List<Integer> toSort, List<Animation> animations,
                            int leftIndex, int rightIndex) {
        int pivotIndex = (leftIndex + rightIndex) / 2;
        int pivot = toSort.get(pivotIndex);
        // find the elements to swap
        while(leftIndex <= rightIndex) {
            //find an element in the left partition greater than the pivot
            while (toSort.get(leftIndex) < pivot) {
                leftIndex++;
            }
            //find an element in the right partition smaller than the pivot
            while(toSort.get(rightIndex) > pivot) {
                rightIndex--;
            }
            //if the indexes didn't overstep, swap the elements
            if(leftIndex <= rightIndex) {
                if(pivotIndex == leftIndex) {
                    pivotIndex = rightIndex;
                } else if(pivotIndex == rightIndex) {
                    pivotIndex = leftIndex;
                }
                animations.add(new QuickSortAnimation(leftIndex, rightIndex, toSort.get(leftIndex), toSort.get(rightIndex), pivotIndex));
                swapElements(toSort, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private void swapElements(List<Integer> toSort, int leftIndex, int rightIndex) {
        //value in the rightIndex
        int temporaryElement = toSort.set(rightIndex, toSort.get(leftIndex));
        toSort.set(leftIndex, temporaryElement);
    }
}
