package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.ProductService;
import com.etiya.ecommercedemopair1.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Category;
import com.etiya.ecommercedemopair1.entities.concretes.Product;
import com.etiya.ecommercedemopair1.repository.abstracts.CategoryRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    // Spring IoC
    @Autowired
    public ProductManager(ProductRepository productRepository, CategoryRepository categoryRepository) { //Dependency Injection
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> getAllByStockGreaterThan(int stock) {
        return productRepository.findAllProductsByStockGreaterThanOrderByStockDesc(stock);
    }

    @Override
    public Product getByName(String name) {
        return productRepository.findByName(name);
    }

    //Current ones
    @Override
    public List<Product> findAllByOrderByNameAsc() {
        return productRepository.findAllByOrderByNameAsc();
    }

    @Override
    public String getProductNameWithId(int id) {
        return productRepository.getProductNameWithId(id);
    }

    @Override
    public GetProductResponse addProduct(AddProductRequest addProductRequest) {
        // Mapping
        Product product = new Product();
        product.setName(addProductRequest.getName());
        product.setStock(addProductRequest.getStock());
        product.setUnitPrice(addProductRequest.getUnitPrice());
        product.setDiscountRate(addProductRequest.getDiscountRate());


        Category category = new Category();

        List<Category> categories = categoryRepository.findAll();
        for (Category secondCategory : categories) {
            if (secondCategory.getId() != category.getId()) {
                throw new RuntimeException("This Category doesn't exist");
            }
        }

        category.setId(addProductRequest.getCategoryId());
        Product savedProduct = productRepository.save(product);

        //productRepository.save(product);

        GetProductResponse getProductResponse = new GetProductResponse(savedProduct.getName(), savedProduct.getStock(),
                savedProduct.getUnitPrice(), savedProduct.getDiscountRate());

        return getProductResponse;
    }

    public void checkCategoryWithId(int id) {
        List<Category> categories = this.categoryRepository.findAll();
        for (Category category : categories) {
            if (category.getId() == id) {
                throw new RuntimeException("This category with specified id already exist.");
            }
        }
    }


}
