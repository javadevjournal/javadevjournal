package com.javadevjournal.repolister.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.javadevjournal.repolister.model.Repo;
import com.javadevjournal.repolister.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SearchController.class, secure = false)
public class SearchControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	private static List<Repo> repoList;
	
	@BeforeClass
	public static void setupTestData() {
		repoList = new ArrayList<Repo>();
		// Populate with test data
		repoList.add(new Repo("1", "Repo1", "Repository 1", "http://myurl.com/1", "Description 1"));
		repoList.add(new Repo("2", "Repo2", "Repository 2", "http://myurl.com/2", "Description 2"));
		repoList.add(new Repo("3", "Repo3", "Repository 3", "http://myurl.com/3", "Description 3"));
		repoList.add(new Repo("4", "Repo4", "Repository 4", "http://myurl.com/4", "Description 4"));
		repoList.add(new Repo("5", "Repo5", "Repository 5", "http://myurl.com/5", "Description 5"));
	}

	@Test
	public void testGetInfo() throws Exception {
		String apiUrl = "/top5/tester";
		// Setup "Mockito" to mock userService call
		Mockito.when(userService.getResults(Mockito.anyString())).thenReturn(repoList);
		
		// Build a GET Request and send it to the test server
		RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);
		MvcResult r = mockMvc.perform(rb).andReturn(); // throws Exception
		
		// Validate response
		String tr = r.getResponse().getContentAsString();
		// System.out.println(tr);
		
		String er = "[{\"id\":\"1\",\"name\":\"Repo1\",\"full_name\":\"Repository 1\",\"html_url\":\"http://myurl.com/1\",\"description\":\"Description 1\"},{\"id\":\"2\",\"name\":\"Repo2\",\"full_name\":\"Repository 2\",\"html_url\":\"http://myurl.com/2\",\"description\":\"Description 2\"},{\"id\":\"3\",\"name\":\"Repo3\",\"full_name\":\"Repository 3\",\"html_url\":\"http://myurl.com/3\",\"description\":\"Description 3\"},{\"id\":\"4\",\"name\":\"Repo4\",\"full_name\":\"Repository 4\",\"html_url\":\"http://myurl.com/4\",\"description\":\"Description 4\"},{\"id\":\"5\",\"name\":\"Repo5\",\"full_name\":\"Repository 5\",\"html_url\":\"http://myurl.com/5\",\"description\":\"Description 5\"}]";
		JSONAssert.assertEquals(er, tr, true);
		
		// Or we can use JUnit's assertEquals() method
		// assertEquals("REST API Returned incorrect response.", er, tr);
	}
}
