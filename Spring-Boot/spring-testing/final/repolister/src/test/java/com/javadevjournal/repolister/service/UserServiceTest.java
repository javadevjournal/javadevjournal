package com.javadevjournal.repolister.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.javadevjournal.repolister.model.Repo;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock
	private RestTemplate rt;
	
	@InjectMocks
	private UserService userService;
	
	static String testUser = "octocat";
	static Repo[] testData;
	
	@BeforeClass
	public static void setUp() throws Exception {
		int l = 3;
		testData = new Repo[l];
		for(int i=0; i<l; i++) {
			testData[i] = new Repo(); 
			// use testData[i].set... methods to make the testData more nuanced, if necessary. 
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testGetResults() {
		// Mock response from External API
		ResponseEntity<Repo []> e = new ResponseEntity<>(testData, HttpStatus.OK);

		Mockito.when(
			rt.getForEntity(
				Mockito.anyString(), 
				(Class<Repo []>) Mockito.any() // unchecked cast warning
			)
		).thenReturn(e);
		
		// Below is the same mock that uses Matchers. However, using Matchers is deprecated.
		// Mockito.when(rt.getForEntity(Matchers.anyString(), Matchers.<Class<Repo []>> any() )).thenReturn(e);

		
		// Invoke method under test
		List<Repo> res = userService.getResults(testUser);
		
		// Validate results: Check overall size as well as each element.
		assertEquals(res.size(), testData.length);
		for(int i=0; i<res.size(); i++) {
			assertEquals(res.get(i), testData[i]);
		}
	}
}
