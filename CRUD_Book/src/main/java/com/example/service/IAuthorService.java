package com.example.service;

import com.example.entity.AuthorEntity;

public interface IAuthorService {
	
		public AuthorEntity addAuthor(AuthorEntity author);
		
		public AuthorEntity updateAuthor(String id, AuthorEntity author);
		
		public boolean delAuthor(String id);
}
