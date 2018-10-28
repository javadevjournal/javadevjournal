package com.javadevjournal.repolister;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.javadevjournal.repolister.controller.SearchController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Top5Test {
	
	@Autowired
	SearchController sc;
	
	private MockMvc mockMvc;
	private String apiUrl = "/top5/%s";
	
	@Before
	public void setup() throws Exception {
		// Setup application context and build mockMvc
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.sc).build();
	}

	@Test
	public void testApiResponse() throws Exception {
		
		// Send an API request and validate response (Headers + Content)
		mockMvc.perform(get(String.format(apiUrl, "octocat")))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(5)))
			.andExpect(jsonPath("$.*.name", hasItem(is("linguist"))))
			.andExpect(jsonPath("$.*.html_url", hasItem(is("https://github.com/octocat/linguist"))));
		
	}
	
	@Test
	public void testUserWithLargeRepoList() throws Exception {
		// Test if API picks the right repo from a user with large number of repos
		mockMvc.perform(get(String.format(apiUrl, "umeshawasthi")))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(5)))
			.andExpect(jsonPath("$.*.name", hasItem(is("blooddonor"))))
			.andExpect(jsonPath("$.*.html_url", hasItem(is("https://github.com/umeshawasthi/blooddonor"))));
	}
	
	@Test
	public void testUserWithSmallRepoList() throws Exception {
		// Test if API handles user with <5 repos correctly (note change in hasSize(...))
		mockMvc.perform(get(String.format(apiUrl, "madhuri2k")))
			.andExpect(status().isOk())
			.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(lessThanOrEqualTo(5))))
			.andExpect(jsonPath("$.*.name", hasItem(is("madhuri2k.github.io"))))
			.andExpect(jsonPath("$.*.html_url", hasItem(is("https://github.com/madhuri2k/fantastic-spoon"))));
	}

}
