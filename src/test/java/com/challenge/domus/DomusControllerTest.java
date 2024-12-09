package com.challenge.domus;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.challenge.domus.beans.ResponseServices;
import com.challenge.domus.services.MoviesServices;

@SpringBootTest
@AutoConfigureMockMvc

public class DomusControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	MoviesServices services;
	
	@Test
    void wrongUrlTest() throws Exception {
        mockMvc.perform(get("/api/direct/5")).andExpect(status().is4xxClientError());
    }
	
	@Test
    void withoutDataTest() throws Exception {
        mockMvc.perform(get("/api/directors/5")).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().string("{\r\n"
        		+ "  \"directores\" : [ ]\r\n"
        		+ "}"));
    }
	
	@Test
    void getDirectorsTest() throws Exception {
        
		Mockito.doReturn(getDirectorsDummy()).when(services).getDirectors(any(Integer.class));
		
		ResponseServices rs = services.getDirectors(3);
		
		assertNotNull(rs.getDirectores());
    }
	
	/**
	 * Made a list with directors for dummy test.
	 * @return
	 */
	private ResponseServices getDirectorsDummy() {
		ResponseServices rs = new ResponseServices();
		
		List<String> directors = new ArrayList<>();
		directors.add("Woody Allen");
		directors.add("M. Night Shyamalan");
		
		rs.setDirectores(directors);
		
		return rs;
	}
	
}
