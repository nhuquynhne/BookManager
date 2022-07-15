package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.AuthorEntity;
import com.example.service.IAuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private IAuthorService iAuthorService;
	
	//Test
		@GetMapping("/")
		public String test() {
			return "helloAuthor";
		}
		
		//API add author
		@PostMapping("/")
		public AuthorEntity addAuthor(@RequestBody AuthorEntity author) {
			return iAuthorService.addAuthor(author);
		}
		
		//API update author
		@PutMapping("/{id}")
		public AuthorEntity updateAuthor(@PathVariable("id") String id, @RequestBody AuthorEntity author) {
			return iAuthorService.updateAuthor(id, author);
		}
		
		//API delete author
		@DeleteMapping("/{id}")
		public boolean delAuthor(@PathVariable("id") String id) {
			return iAuthorService.delAuthor(id);
		}
}
