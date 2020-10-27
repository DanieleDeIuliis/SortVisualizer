package com.sortvisualizer.controller;

import com.sortvisualizer.model.Animation;
import com.sortvisualizer.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sort")
@CrossOrigin("http://localhost:3000")
public class SortController {

    @Autowired
    SortService sortService;



    @PostMapping("/{sortAlgorithm}")
    ResponseEntity<List<Integer>> sort(@PathVariable String sortAlgorithm,
                                       @RequestBody List<Integer> numbersToSort) {
        sortService.sort(numbersToSort, sortAlgorithm);
        return ResponseEntity.ok().body(numbersToSort);
    }

    @PostMapping("/{sortAlgorithm}/animations")
    ResponseEntity<List<Animation>> getMergeSortAnimations(@PathVariable String sortAlgorithm,
                                                                    @RequestBody List<Integer> numbersToSort) {
        List<Animation> animations = sortService.sort(numbersToSort, sortAlgorithm);
        return ResponseEntity.ok().body(animations);
    }

}
