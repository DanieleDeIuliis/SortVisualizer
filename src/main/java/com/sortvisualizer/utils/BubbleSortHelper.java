package com.sortvisualizer.utils;

import com.sortvisualizer.model.Animation;
import com.sortvisualizer.model.BubbleSortAnimation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

@Component
public class BubbleSortHelper implements SortHelper {

    @Override
    public List<Animation> sort(List<Integer> arrayToSort) {
        List<Animation> animations = new ArrayList<>();
        boolean isSorted = false;
        BiPredicate<List<Integer>, Integer> isSwapRequired = (list, index) -> list.get(index) > list.get(index + 1);
        while(!isSorted) {
            isSorted = true;
            for(int i = 0; i < arrayToSort.size() - 1; i++) {
                if(isSwapRequired.test(arrayToSort, i)) {
                    isSorted = swap(arrayToSort, i, animations);
                }
            }
        }
        return animations;
    }

    private boolean swap(List<Integer> arrayToSort, int index, List<Animation> animations) {
        animations.add(new BubbleSortAnimation(index, index + 1,
                arrayToSort.get(index), arrayToSort.get(index + 1) ));
        int temp = arrayToSort.get(index);
        arrayToSort.set(index, arrayToSort.get(index + 1));
        arrayToSort.set(index + 1, temp);
        return false;
    }
}
