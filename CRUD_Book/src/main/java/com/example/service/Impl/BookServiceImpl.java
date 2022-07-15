package com.example.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.BookEntity;
import com.example.repository.BookRepository;
import com.example.service.IBookService;

@Service
public class BookServiceImpl implements IBookService{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public BookEntity addBook(BookEntity book) {
		// TODO Auto-generated method stub
		if(book != null) {
			return bookRepository.save(book);
		}
		return null;
	}

	@Override
	public BookEntity updateBook(String id, BookEntity book) {
		// TODO Auto-generated method stub
		if(book != null) {
			BookEntity book1 = bookRepository.getOne(id);
			if(book1 != null) {
				book1.setName(book.getName());
				book1.setNamXB(book.getNamXB());
				book1.setPrice(book.getPrice());
				book1.setNumTitle(book.getNumTitle());
				book1.setNumNow(book.getNumNow());
				book1.setCreatedBy(book.getCreatedBy());
				book1.setCreatedDate(book.getCreatedDate());
				book1.setModifiedBy(book.getModifiedBy());
				book1.setModifiedDate(book.getModifiedDate());
				
				return bookRepository.save(book1);
			}
		}
		return null;
	}

	@Override
	public boolean delBook(String id) {
		// TODO Auto-generated method stub
		//if(id>=1) {
			BookEntity book = bookRepository.getOne(id);
			if(book != null) {
				bookRepository.delete(book);
				return true;
			}
		//}
		return false;
	}

//	@Override
//	public List<BookEntity> getAllBook() {
//		// TODO Auto-generated method stub
//		return bookRepository.findAll();
//	}
//
//	@Override
//	public BookEntity getOneBook(String id) {
//		// TODO Auto-generated method stub
//		return bookRepository.getById(null);
//	}

}
