package com.javadevjournal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javadevjournal.data.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBeanValidationJsr303ApplicationTests {


    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired WebApplicationContext wac;

    @Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void contextLoads() throws Exception {

        Customer customer = new Customer();
        customer.setName("Java Dev Journal");
        customer.setAge(34);
        customer.setEmail("contact-us");
        String requestBody = objectMapper.writeValueAsString(customer);


        ResultActions result=this.mockMvc.perform(post("/customers/customer")
				.contentType(MediaType.APPLICATION_JSON).content(requestBody))
				.andExpect(status().isOk());
	}

}

