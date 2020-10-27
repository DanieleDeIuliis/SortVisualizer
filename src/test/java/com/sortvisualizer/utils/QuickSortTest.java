package com.sortvisualizer.utils;

import com.sortvisualizer.model.Animation;
import com.sortvisualizer.model.BubbleSortAnimation;
import com.sortvisualizer.model.QuickSortAnimation;
import com.sortvisualizer.model.SelectionSortAnimation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSortTest {

    private QuickSortHelper quickSortHelper;

    @BeforeEach
    public void setUp(){
        quickSortHelper = new QuickSortHelper();
    }

    @Test
    void quickSortTest(){
        List<Integer> toSort =
                new Random().ints(100)
                        .boxed()
                        .collect(Collectors.toList());
        List<Integer> toMatch = new ArrayList<>(toSort);
        toMatch.sort(Comparator.naturalOrder());
        quickSortHelper.sort(toSort);
        Assertions.assertEquals(toMatch, toSort);
    }

    @Test
    public void quickSortAnimationTest(){
        List<Integer> toSort = Stream.of(4,3,2,1).collect(Collectors.toList());
        List<Animation> animations = quickSortHelper.sort(toSort);
        List<QuickSortAnimation> animationsToTest = getAnimationsList();
        for(int i = 0; i < animations.size(); i++){
            QuickSortAnimation castedAnimation = (QuickSortAnimation) animations.get(i);
            QuickSortAnimation tester = animationsToTest.get(i);
            Assertions.assertEquals(tester.getFirstIndexToCompare(), castedAnimation.getFirstIndexToCompare());
            Assertions.assertEquals(tester.getLeftValueToSwap(), castedAnimation.getLeftValueToSwap());
            Assertions.assertEquals(tester.getRightValueToSwap(), castedAnimation.getRightValueToSwap());
            Assertions.assertEquals(tester.getSecondIndexToCompare(), castedAnimation.getSecondIndexToCompare());
            Assertions.assertEquals(tester.getPivot(), castedAnimation.getPivot());
        }
    }

    private List<QuickSortAnimation> getAnimationsList() {
        return Stream.of(
                new QuickSortAnimation(0, 3, 4, 1,1),
                new QuickSortAnimation(1, 2, 3, 2,2),
                new QuickSortAnimation(0, 0, 1, 1,0),
                new QuickSortAnimation(2, 2, 3, 3,2))
                .collect(Collectors.toList());
    }
}
