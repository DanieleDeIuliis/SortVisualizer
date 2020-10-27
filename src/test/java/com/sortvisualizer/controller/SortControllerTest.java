package com.sortvisualizer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sortvisualizer.service.GeneralSortService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SortController.class)
class SortControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private GeneralSortService service;

	private List<Integer> numbers;

	@BeforeEach
	public void setUp(){
		numbers = Arrays.asList(4,3,2,1);
	}

	@Test
	void mergeSortTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/sort/mergesort")
				.accept(MediaType.APPLICATION_JSON)
				.content(numbers.toString())
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(MockMvcResultMatchers.jsonPath("$").exists())
		.andExpect(status().isOk());
	}

	@Test
	void mergeSortAnimationsTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/sort/mergesort/animations")
				.accept(MediaType.APPLICATION_JSON)
				.content(numbers.toString())
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(MockMvcResultMatchers.jsonPath("$").exists())
				.andExpect(status().isOk());
	}


}
