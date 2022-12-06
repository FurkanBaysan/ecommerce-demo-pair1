package com.etiya.ecommercedemopair1.business.abstracts;

import com.etiya.ecommercedemopair1.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.customer.GetCustomerResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAll();

    public Customer getById(int id);

    public String findEmailByName(String name);

    public List<Customer> getCustomerWithGender(String gender);

    public void addCustomer(AddCustomerRequest addCustomerRequest); // Sadece Request'li görelim.

    public GetCustomerResponse addCustomerWithCustomerInfo(AddCustomerRequest addCustomerRequest); // Bir de Response'lu görelim.addCustomer gibi.

}
