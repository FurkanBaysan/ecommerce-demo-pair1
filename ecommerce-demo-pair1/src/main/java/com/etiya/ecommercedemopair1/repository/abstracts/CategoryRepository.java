package com.etiya.ecommercedemopair1.repository.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.category.GetCategoryResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    // In summary, here are the queries
    public List<Category> findAllByName(String name);

    @Query("select c from Category c order by c.id desc")
    public List<Category> getCategoryWithIdDesc();

   // boolean existsCategoryByName(String name); // Tek bir sonuc alması icin.

    //@Query("select c from Category where c.id=:id")
    //Category searchById(int id);

    List<Category> findAll();
}
