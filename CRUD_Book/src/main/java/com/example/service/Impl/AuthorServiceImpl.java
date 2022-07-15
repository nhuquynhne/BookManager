package com.example.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.AuthorEntity;
import com.example.repository.AuthorRepository;
import com.example.service.IAuthorService;

@Service
public class AuthorServiceImpl implements IAuthorService{

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public AuthorEntity addAuthor(AuthorEntity author) {
		// TODO Auto-generated method stub
		if(author != null) {
			return authorRepository.save(author);
		}
		return null;
	}

	@Override
	public AuthorEntity updateAuthor(String id, AuthorEntity author) {
		// TODO Auto-generated method stub
		if(author != null) {
			AuthorEntity author1 = authorRepository.getOne(id);
			if(author1 != null) {
				author1.setName(author.getName());
				author1.setDob(author.getDob());
				author1.setStory(author.getStory());
				author1.setCreatedBy(author.getCreatedBy());
				author1.setCreatedDate(author.getCreatedDate());
				author1.setModifiedBy(author.getModifiedBy());
				author1.setModifiedDate(author.getModifiedDate());
				
				return authorRepository.save(author1);
			}
		}
		return null;
	}

	@Override
	public boolean delAuthor(String id) {
		// TODO Auto-generated method stub
		AuthorEntity author = authorRepository.getOne(id);
		if(author != null) {
			authorRepository.delete(author);
			return true;
		}
		return false;
	}

}
