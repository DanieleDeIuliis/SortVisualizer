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
    public List<Animation> sort(List<Integer> numbers) {
        List<Animation> animations = new ArrayList<>();
        boolean isSorted = false;
        BiPredicate<List<Integer>, Integer> isSwapRequired = (list, index) -> list.get(index) > list.get(index + 1);
        while(!isSorted) {
            isSorted = true;
            for(int i = 0; i < numbers.size() - 1; i++) {
                if(isSwapRequired.test(numbers, i)) {
                    isSorted = swap(numbers, i, animations);
                }
            }
        }
        return animations;
    }

    private boolean swap(List<Integer> numbers, int index, List<Animation> animations) {
        animations.add(new BubbleSortAnimation(index, index + 1,
                numbers.get(index), numbers.get(index + 1) ));
        int temp = numbers.get(index);
        numbers.set(index, numbers.get(index + 1));
        numbers.set(index + 1, temp);
        return false;
    }
}
