package com.spring.api.demo3.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.api.demo3.pojo.Releases;

@SpringBootTest
class ReleaseResourceTest {

	@Autowired
	private WebApplicationContext ctx;

	@Autowired
	private ObjectMapper mapper;

	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void add() throws Exception {
		Releases input = new Releases();
		input.setName("21.x.1");
		input.setDescription("drop3");
		input.setDate(LocalDateTime.now());
		mockMvc.perform(MockMvcRequestBuilders.post("/release/add").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(input))).andExpect(status().isOk());

	}

	@Test
	public void get() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/release/list")).andExpect(status().isOk())
				.andReturn();
		String jsonString = result.getResponse().getContentAsString();
		List<Releases> list = mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, Releases.class));
		System.out.println(jsonString);
		System.out.println(list);
		Assertions.assertEquals(list.get(0).getName(), "21.x.1");
		Assertions.assertEquals(list.get(0).getStatus(), "Production");
		//Assertions.

	}

}
