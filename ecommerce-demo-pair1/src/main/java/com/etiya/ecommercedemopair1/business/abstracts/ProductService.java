package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAll();

    public Product getById(int id);

    public List<Product> getAllByStockGreaterThan(int stock);

    public Product getByName(String name);

    List<Product> findAllByOrderByNameAsc();

    public String getProductNameWithId(int id);

    public GetProductResponse addProduct(AddProductRequest addProductRequest);
}
