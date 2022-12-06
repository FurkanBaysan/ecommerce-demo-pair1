package com.etiya.ecommercedemopair1.repository.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public String findEmailByName(String name);

    @Query("select c from Customer c where c.gender=:gender")
    public List<Customer> getCustomerWithGender(String gender);
}
