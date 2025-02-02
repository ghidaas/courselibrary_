package com.courselibraryy.courselibrary.service;

import com.courselibraryy.courselibrary.entity.Book;
import com.courselibraryy.courselibrary.entity.Category;
import com.courselibraryy.courselibrary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
@Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAllCategories(){

        return categoryRepository.findAll();
    }

public Category findCategoryById(int id){
    Category category =categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("book not category"));
    return category;
}
    public void createCategory(Category category){
        categoryRepository.save(category);
    }


public void deleteCategory(int id){
    Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category with id " + id + " not found"));
    categoryRepository.deleteById(category.getId());
}
    public void updateCategory(Category category){
        categoryRepository.save(category);
    }

}


