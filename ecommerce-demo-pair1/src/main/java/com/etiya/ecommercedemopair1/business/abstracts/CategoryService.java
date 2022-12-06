package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.category.GetCategoryResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    // get() methods..
    public List<Category> getAll();

    public Category getById(int id);

    public List<Category> findAllByName(String name);

    public List<Category> getCategoryWithIdDesc();

    // Post methods..

    // public void addCategory(Category category);

    //public Category addCategory(AddCategoryRequest addCategoryRequest);
    public GetCategoryResponse addCategory(AddCategoryRequest addCategoryRequest);

    public GetCategoryResponse getCategoryResponse(AddCategoryRequest addCategoryRequest);




}
