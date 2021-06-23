package com.vm;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



@SpringBootTest
public class HelloResourceTest {

	MockMvc mockMvc;

	@InjectMocks
	HelloResource helloResource;

	
	@Test
	public void testSayHello() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(helloResource).build();

		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("Hello sai"));
	}
	
	
	@Test
	public void testStudentJson() throws Exception
	{
		mockMvc = MockMvcBuilders.standaloneSetup(helloResource).build();
		
		mockMvc.perform(get("/student"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(jsonPath("$.name", Matchers.is("sai")))
		.andExpect(jsonPath("$.age", Matchers.is(22)));


	}
	
	
	

}