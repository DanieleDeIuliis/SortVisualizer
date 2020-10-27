package com.sortvisualizer.utils;

import com.sortvisualizer.model.Animation;
import com.sortvisualizer.model.MergeSortAnimation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

@Component
public class MergeSortHelper implements SortHelper {

    public List<Animation> sort(List<Integer> toSort){
        List<Animation> animations = new ArrayList<>();
        mergeSort(toSort, animations, 0, toSort.size() - 1);
        return animations;
    }

    public void mergeSort(List<Integer> toSort, List<Animation> animations,
                          int lowIndex, int highIndex) {
        if(lowIndex < highIndex) {
            int middleIndex = (lowIndex + highIndex) / 2;
            mergeSort(toSort, animations, lowIndex, middleIndex);
            mergeSort(toSort, animations, middleIndex + 1, highIndex);
            doMerge(toSort, animations, lowIndex, middleIndex, highIndex);
        }
    }

    private void doMerge(List<Integer> toSort, List<Animation> animations,
                                  int lowIndex, int middleIndex, int highIndex) {
        List<Integer> temp = new ArrayList<>(toSort);

        int currentLeft = lowIndex;
        int currentRight = middleIndex + 1;
        int current = lowIndex;
        MergeSortAnimation animation;
        BiPredicate<Integer, Integer> indexesInRange =
                (left, right) -> left <= middleIndex && right <= highIndex;

        while(indexesInRange.test(currentLeft, currentRight)) {

            if(temp.get(currentLeft) <= temp.get(currentRight)) {
                toSort.set(current, temp.get(currentLeft));
                animation = new MergeSortAnimation(currentLeft,currentRight,
                        current,temp.get(currentLeft));
                currentLeft++;
            } else {
                toSort.set(current, temp.get(currentRight));
                animation = new MergeSortAnimation(currentLeft,currentRight,
                        current,temp.get(currentRight));
                currentRight++;
            }
            current++;
            animations.add(animation);
        }

        int remaining = middleIndex - currentLeft;

        for (int i = 0; i <= remaining; i++) {
            animation = new MergeSortAnimation(currentLeft + i,
                    currentLeft + i, current + i,
                     temp.get(currentLeft + i));
            animations.add(animation);
            toSort.set(current + i, temp.get(currentLeft + i));
        }
    }
}
