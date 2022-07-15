package com.example.service;

//import java.util.List;

//import java.util.List;

import com.example.entity.BookEntity;

public interface IBookService {
	//hàm thêm sách
	public BookEntity addBook(BookEntity book);
	
	//Hàm chỉnh sửa thông tin Sách
	public BookEntity updateBook(String id, BookEntity book);
	
	//Hàm xóa Sách
	public boolean delBook(String id);
	
//	//Hàm lấy ra danh sách Sách
//	public List<BookEntity> getAllBook();
//	
//	//Hàm lấy ra 1 Sách
//	public BookEntity getOneBook(String id);
}
