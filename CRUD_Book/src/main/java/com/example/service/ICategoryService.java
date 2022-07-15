package com.example.service;

import java.util.List;

//import java.util.List;

import com.example.entity.CategoryEntity;

public interface ICategoryService {
	// hàm thêm the loai
		public CategoryEntity addCategory(CategoryEntity category);
		
		//Hàm chỉnh sửa thông tin the loai
		public CategoryEntity updateCategory(String id, CategoryEntity category);
		
		//Hàm xóa the loai
		public boolean delCategory(String id);
		
		//Hàm lấy ra danh sách the loai
		public List<CategoryEntity> getAllCategory();
		
		//Hàm lấy ra 1 the loai
		public CategoryEntity getOneCategory(String id);
}
