package com.demo.springcloud.microservices.books.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

	@RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
	public String spittle(@PathVariable("bookTitleId") String title) {
		return "book";
	}

}
