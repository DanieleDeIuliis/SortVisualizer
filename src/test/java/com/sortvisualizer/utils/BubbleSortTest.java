package com.sortvisualizer.utils;

import com.sortvisualizer.model.Animation;
import com.sortvisualizer.model.BubbleSortAnimation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BubbleSortTest {

    private BubbleSortHelper bubbleSortHelper;

    @BeforeEach
    public void setUp(){
        bubbleSortHelper = new BubbleSortHelper();
    }

    @Test
    void bubbleSortTest() {
        List<Integer> toSort =
                new Random().ints(100)
                        .boxed()
                        .collect(Collectors.toList());
        List<Integer> toMatch = new ArrayList<>(toSort);
        toMatch.sort(Comparator.naturalOrder());
        bubbleSortHelper.sort(toSort);
        Assertions.assertEquals(toMatch, toSort);
    }

    @Test
    public void bubbleSortAnimationTest(){
        List<Integer> toSort = Stream.of(4,3,2,1).collect(Collectors.toList());
        List<Animation> animations = bubbleSortHelper.sort(toSort);
        List<BubbleSortAnimation> animationsToTest = getAnimationsList();
        for(int i = 0; i < animations.size(); i++){
            BubbleSortAnimation castedAnimation = (BubbleSortAnimation) animations.get(i);
            BubbleSortAnimation tester = animationsToTest.get(i);
            Assertions.assertEquals(tester.getFirstIndexToCompare(), castedAnimation.getFirstIndexToCompare());
            Assertions.assertEquals(tester.getLeftValueToSwap(), castedAnimation.getLeftValueToSwap());
            Assertions.assertEquals(tester.getRightValueToSwap(), castedAnimation.getRightValueToSwap());
            Assertions.assertEquals(tester.getSecondIndexToCompare(), castedAnimation.getSecondIndexToCompare());
        }
    }

    private List<BubbleSortAnimation> getAnimationsList() {
        return Stream.of(
                new BubbleSortAnimation(0, 1, 4, 3),
                new BubbleSortAnimation(1, 2, 4, 2),
                new BubbleSortAnimation(2, 3, 4, 1),
                new BubbleSortAnimation(0, 1, 3, 2),
                new BubbleSortAnimation(1, 2, 3, 1),
                new BubbleSortAnimation(0, 1, 2, 1))
                .collect(Collectors.toList());
    }
}
