package com.example.controller;

import java.util.List;

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

import com.example.entity.CategoryEntity;
import com.example.service.ICategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private ICategoryService iCategoryService;
	
	//Test
	@GetMapping("/")
	public String test() {
		return "helloCategory";
	}
	
	//API add category
	@PostMapping("/")
	public CategoryEntity addCategory(@RequestBody CategoryEntity category) {
		return iCategoryService.addCategory(category);
	}
	
	//API update category
	@PutMapping("/{id}")
	public CategoryEntity updateCategory(@PathVariable("id") String id, @RequestBody CategoryEntity category) {
		return iCategoryService.updateCategory(id, category);
	}
	
	//API delete category
	@DeleteMapping("/{id}")
	public boolean delCategory(@PathVariable("id") String id) {
		return iCategoryService.delCategory(id);
	}
	
	//API lay danh sach
	@GetMapping("/list")
	public List<CategoryEntity> getAllCategory(){
		return iCategoryService.getAllCategory();
	}
	
	@GetMapping("/list/{id}")
	public CategoryEntity getOneCategory(@PathVariable("id") String id) {
		// TODO Auto-generated method stub
		return iCategoryService.getOneCategory(id);
	}
}
