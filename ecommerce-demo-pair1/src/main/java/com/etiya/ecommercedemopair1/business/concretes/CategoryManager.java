package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.CategoryService;
import com.etiya.ecommercedemopair1.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.category.GetCategoryResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import com.etiya.ecommercedemopair1.repository.abstracts.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryManager(CategoryRepository categoryRepository) { //Dependency Injection
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        return this.categoryRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Category> findAllByName(String name) {
        return this.categoryRepository.findAllByName(name);
    }

    @Override
    public List<Category> getCategoryWithIdDesc() {
        return this.categoryRepository.getCategoryWithIdDesc();
    }
    //    @Override
//    public void addCategory(Category category) {
//        this.categoryRepository.save(category);
//    }

    // JPA Repository save() methodu, eklenen nesneyi(datayı) geri döndürür.
//    @Override
//    public Category addCategory(AddCategoryRequest addCategoryRequest) {
//        // Mapping
//        Category category = new Category();
//        category.setName(addCategoryRequest.getName());
//        Category savedCategory = this.categoryRepository.save(category);
//        // save(category)=> this method returns a category object.
//        return savedCategory;
//    }
    public GetCategoryResponse addCategory(AddCategoryRequest addCategoryRequest) {
        // MappingCategory
        //  Mapping: AUTO MAPPER
        //  TODO: Implement auto mapper
        Category category = new Category();
        category.setName(addCategoryRequest.getName());
        Category savedCategory = this.categoryRepository.save(category);
        // save(category)=> this method returns a category object.
        //return savedCategory;


        //Mapping => Category => AddCategoryResponse
        GetCategoryResponse response =
                new GetCategoryResponse(savedCategory.getId(), savedCategory.getName());
        return response;
    }

    @Override
    public GetCategoryResponse getCategoryResponse(AddCategoryRequest addCategoryRequest) {

        Category category = new Category();
        category.setName(addCategoryRequest.getName());

        checkCategoryNameExists(category);
        Category savedCategory = this.categoryRepository.save(category);

        GetCategoryResponse getCategoryResponse = new GetCategoryResponse();
        getCategoryResponse.setName(savedCategory.getName());

        return getCategoryResponse;

    }

    private void checkCategoryNameExists(Category category) {
        List<Category> categories = categoryRepository.findAll();

        for (Category secondCategory : categories) {
            if (secondCategory.getName().equals(category.getName())) {
                throw new RuntimeException("This category already exists");
            }
        }
    }


}
