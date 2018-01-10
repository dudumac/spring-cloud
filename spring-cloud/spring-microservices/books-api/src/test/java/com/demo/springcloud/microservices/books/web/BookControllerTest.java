package com.demo.springcloud.microservices.books.web;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import com.demo.springcloud.microservices.data.model.Book;

//import spittr.Spittle;
//import spittr.data.SpittleRepository;
//import spittr.web.SpittleController;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
@DirtiesContext(methodMode=MethodMode.AFTER_METHOD)
public class BookControllerTest {

	MockMvc mockMvc;
	
	@Before
	public void setUp() {
		BookController controller = new BookController();
		
		mockMvc = standaloneSetup(controller)
				.build();
	}
	
/*
	@Test
	public void shouldShowPagedSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(50);
		when(mockRepository.findSpittles(238900, 50)).thenReturn(expectedSpittles);

		mockMvc.perform(get("/spittles?max=238900&count=50"))
				.andExpect(view().name("spittles"))
				.andExpect(model().attributeExists("spittleList"))
				.andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
	}
*/
	
	@Test
	public void testGetBook() throws Exception {
		Book expectedBook = new Book("BookTitle", "BookAuthor");
//		when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);
		
		mockMvc.perform(get("/books/12345"))
        		.andExpect(status().isOk())
	            .andExpect(content().contentType("application/json;charset=UTF-8")) 
	            .andExpect(content().encoding("UTF-8"))
	            .andExpect(jsonPath("$", hasSize(8)));
	}

}
