package com.sortvisualizer.utils;

import com.sortvisualizer.model.Animation;
import com.sortvisualizer.model.BubbleSortAnimation;
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

public class SelectionSortTest {

    private SelectionSortHelper selectionSortHelper;

    @BeforeEach
    public void setUp(){
        selectionSortHelper = new SelectionSortHelper();
    }

    @Test
    void selectionSortTest(){
        List<Integer> toSort =
                new Random().ints(100)
                        .boxed()
                        .collect(Collectors.toList());
        List<Integer> toMatch = new ArrayList<>(toSort);
        toMatch.sort(Comparator.naturalOrder());
        selectionSortHelper.sort(toSort);
        Assertions.assertEquals(toMatch, toSort);
    }

    @Test
    public void bubbleSortAnimationTest(){
        List<Integer> toSort = Stream.of(4,3,2,1).collect(Collectors.toList());
        List<Animation> animations = selectionSortHelper.sort(toSort);
        List<SelectionSortAnimation> animationsToTest = getAnimationsList();
        animations.forEach(System.out::println);
        for(int i = 0; i < animations.size(); i++){
            SelectionSortAnimation castedAnimation = (SelectionSortAnimation) animations.get(i);
            SelectionSortAnimation tester = animationsToTest.get(i);
            Assertions.assertEquals(tester.getFirstIndexToCompare(), castedAnimation.getFirstIndexToCompare());
            Assertions.assertEquals(tester.getLeftValueToSwap(), castedAnimation.getLeftValueToSwap());
            Assertions.assertEquals(tester.getRightValueToSwap(), castedAnimation.getRightValueToSwap());
            Assertions.assertEquals(tester.getSecondIndexToCompare(), castedAnimation.getSecondIndexToCompare());
        }
    }

    private List<SelectionSortAnimation> getAnimationsList() {
        return Stream.of(
                new SelectionSortAnimation(0, 3, 4, 1),
                new SelectionSortAnimation(1, 2, 3, 2),
                new SelectionSortAnimation(2, 2, 3, 3),
                new SelectionSortAnimation(3, 3, 4, 4))
                .collect(Collectors.toList());
    }

}
