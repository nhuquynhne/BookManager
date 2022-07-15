package com.example.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.BookEntity;
import com.example.service.IBookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private IBookService iBookService;
	
	//Test
	@GetMapping("/")
	public String test() {
		return "hellobook";
	}
	
	//API add book
	@PostMapping("/")
	public BookEntity addBook(@RequestBody BookEntity book) {
		return iBookService.addBook(book);
	}
	
	//API update book
	@PutMapping("/{id}")
	public BookEntity updateBook(@PathVariable("id") String id, @RequestBody BookEntity book) {
		return iBookService.updateBook(id, book);
	}
	
	//API delete book
	@DeleteMapping("/{id}")
	public boolean delBook(@PathVariable("id") String id) {
		return iBookService.delBook(id);
	}
	
//	//API lay danh sach
//	@GetMapping("/list")
//	public List<BookEntity> getAllBook(){
//		return iBookService.getAllBook();
//	}
	
}
