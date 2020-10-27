package com.sortvisualizer.utils;

import com.sortvisualizer.model.Animation;
import com.sortvisualizer.model.BubbleSortAnimation;
import com.sortvisualizer.model.MergeSortAnimation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSortTest {

    private MergeSortHelper mergeSortHelper;

    @BeforeEach
    public void setUp(){
        mergeSortHelper = new MergeSortHelper();
    }

    @Test
    void quickSortTest(){
        List<Integer> toSort =
                new Random().ints(100)
                        .boxed()
                        .collect(Collectors.toList());
        List<Integer> toMatch = new ArrayList<>(toSort);
        toMatch.sort(Comparator.naturalOrder());
        mergeSortHelper.sort(toSort);
        Assertions.assertEquals(toMatch, toSort);
    }

    @Test
    public void mergeSortAnimationTest(){
        List<Integer> toSort = Stream.of(4,3,2,1).collect(Collectors.toList());
        List<Animation> animations = mergeSortHelper.sort(toSort);
        List<MergeSortAnimation> animationsToTest = getAnimationsList();
        for(int i = 0; i < animations.size(); i++){
            MergeSortAnimation castedAnimation = (MergeSortAnimation) animations.get(i);
            MergeSortAnimation tester = animationsToTest.get(i);
            Assertions.assertEquals(tester.getFirstIndexToCompare(), castedAnimation.getFirstIndexToCompare());
            Assertions.assertEquals(tester.getSecondIndexToCompare(), castedAnimation.getSecondIndexToCompare());
            Assertions.assertEquals(tester.getIndexToMove(), castedAnimation.getIndexToMove());
            Assertions.assertEquals(tester.getValueToSet(), castedAnimation.getValueToSet());
        }
    }

    private List<MergeSortAnimation> getAnimationsList() {
        return Stream.of(
                new MergeSortAnimation(0, 1, 0, 3),
                new MergeSortAnimation(0, 0, 1, 4),
                new MergeSortAnimation(2, 3, 2, 1),
                new MergeSortAnimation(2, 2, 3, 2),
                new MergeSortAnimation(0, 2, 0, 1),
                new MergeSortAnimation(0, 3, 1, 2),
                new MergeSortAnimation(0, 0, 2, 3),
                new MergeSortAnimation(1, 1, 3, 4))
                .collect(Collectors.toList());
    }
}
