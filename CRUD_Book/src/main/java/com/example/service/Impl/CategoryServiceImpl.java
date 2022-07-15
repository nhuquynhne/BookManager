package com.example.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.CategoryEntity;
import com.example.repository.CategoryRepository;
import com.example.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public CategoryEntity addCategory(CategoryEntity category) {
		// TODO Auto-generated method stub
		if(category != null) {
			return categoryRepository.save(category);
		}
		return null;
	}

	public CategoryEntity updateCategory(String id, CategoryEntity category) {
		// TODO Auto-generated method stub
		if(category != null) {
			CategoryEntity category1 = categoryRepository.getOne(id);
			if(category1 != null) {
				category1.setName(category.getName());
				category1.setCreatedBy(category.getCreatedBy());
				category1.setCreatedDate(category.getCreatedDate());
				category1.setModifiedBy(category.getModifiedBy());
				category1.setModifiedDate(category.getModifiedDate());
				
				return categoryRepository.save(category1);
			}
		}
		return null;
	}

	@Override
	public boolean delCategory(String id) {
		// TODO Auto-generated method stub
		CategoryEntity category = categoryRepository.getOne(id);
		if(category != null) {
			categoryRepository.delete(category);
			return true;
		}
		return false;
	}

	@Override
	public List<CategoryEntity> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public CategoryEntity getOneCategory(String id) {
		// TODO Auto-generated method stub
		return categoryRepository.getOne(id);
	}

}
