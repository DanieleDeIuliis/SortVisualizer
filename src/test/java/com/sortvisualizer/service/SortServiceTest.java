package com.sortvisualizer.service;

import com.sortvisualizer.model.*;
import com.sortvisualizer.utils.BubbleSortHelper;
import com.sortvisualizer.utils.MergeSortHelper;
import com.sortvisualizer.utils.QuickSortHelper;
import com.sortvisualizer.utils.SelectionSortHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;

public class SortServiceTest {

    @Mock
    private BubbleSortHelper bubbleSortHelper;
    @Mock
    private SelectionSortHelper selectionSortHelper;
    @Mock
    private QuickSortHelper quickSortHelper;
    @Mock
    private MergeSortHelper mergeSortHelper;
    @InjectMocks
    private GeneralSortService service;

    private List<Integer> numbers;

    @BeforeEach
    public void setUp(){
        numbers = Arrays.asList(4,3,2,1);
        MockitoAnnotations.initMocks(this);
    }



    @Test
    public void bubbleSortTest(){
        BubbleSortAnimation dummy = new BubbleSortAnimation(1,2,3,4);
        doReturn(List.of(dummy)).when(bubbleSortHelper).sort(numbers);
        List<Animation> result = service.sort(numbers, "bubblesort");
        Assertions.assertEquals(dummy, result.get(0));
    }

    @Test
    public void selectionSortTest(){
        SelectionSortAnimation dummy = new SelectionSortAnimation(1,2,3,4);
        doReturn(List.of(dummy)).when(selectionSortHelper).sort(numbers);
        List<Animation> result = service.sort(numbers, "selectionsort");
        Assertions.assertEquals(dummy, result.get(0));
    }

    @Test
    public void quickSortTest(){
        QuickSortAnimation dummy = new QuickSortAnimation(1,2,3,4,1);
        doReturn(List.of(dummy)).when(quickSortHelper).sort(numbers);
        List<Animation> result = service.sort(numbers, "quicksort");
        Assertions.assertEquals(dummy, result.get(0));
    }

    @Test
    public void mergeSortTest(){
        MergeSortAnimation dummy = new MergeSortAnimation(1,2,3,4);
        doReturn(List.of(dummy)).when(mergeSortHelper).sort(numbers);
        List<Animation> result = service.sort(numbers, "mergesort");
        Assertions.assertEquals(dummy, result.get(0));
    }

    @Test
    public void wrongSortMethodPassed(){
        Assertions.assertNull(service.sort(numbers,"wrongMethod"));
    }
}
