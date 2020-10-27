package com.sortvisualizer.service;

import com.sortvisualizer.model.Animation;
import com.sortvisualizer.utils.BubbleSortHelper;
import com.sortvisualizer.utils.MergeSortHelper;
import com.sortvisualizer.utils.QuickSortHelper;
import com.sortvisualizer.utils.SelectionSortHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralSortService implements SortService {

    @Autowired
    MergeSortHelper mergeSortHelper;
    @Autowired
    QuickSortHelper quickSortHelper;
    @Autowired
    SelectionSortHelper selectionSortHelper;
    @Autowired
    BubbleSortHelper bubbleSortHelper;

    @Override
    public List<Animation> sort(List<Integer> numbers, String sortMethodToCall) {
        switch (sortMethodToCall) {
            case "mergesort":
                return mergeSortHelper.sort(numbers);
            case "quicksort":
                return quickSortHelper.sort(numbers);
            case "selectionsort":
                return selectionSortHelper.sort(numbers);
            case "bubblesort":
                return  bubbleSortHelper.sort(numbers);
            default:
                return null;
        }
    }

}
