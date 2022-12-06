package com.etiya.ecommercedemopair1.repository.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Product;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    //findAll-Products-By-Stock(int stock)
    //findAll-Products-By-Stock-GreaterThan(int stock)
    //findAll-Products-By-Stock-GreaterThan-OrderBy(int stock)

    // Stock sayısına göre stock özelliği gelen int değerden fazla olan productlar (below query)
    public List<Product> findAllProductsByStockGreaterThanOrderByStockDesc(int stock);

    @Query("Select p from Product as p WHERE name=:name")
    public Product findByName(String name);

    List<Product> findAllByOrderByNameAsc();

    @Query("Select p.name from Product as p where p.id=:id")
    String getProductNameWithId(int id);

}
