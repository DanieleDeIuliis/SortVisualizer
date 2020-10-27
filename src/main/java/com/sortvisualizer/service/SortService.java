package com.sortvisualizer.service;

import com.sortvisualizer.model.Animation;

import java.util.List;

public interface SortService {
    List<Animation> sort(List<Integer> numbers, String sortMethodToCall);
}
