package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.CustomerService;
import com.etiya.ecommercedemopair1.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.customer.GetCustomerResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Customer;
import com.etiya.ecommercedemopair1.repository.abstracts.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository) { //Dependency Injection
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).orElseThrow();
    }

    @Override
    public String findEmailByName(String name) {
        return this.customerRepository.findEmailByName(name);
    }

    @Override
    public List<Customer> getCustomerWithGender(String gender) {
        return customerRepository.getCustomerWithGender(gender);
    }

    @Override
    public void addCustomer(AddCustomerRequest addCustomerRequest) {
        // this.customerRepository.save(customer);

        // Mapping
        Customer customer = new Customer();

        customer.setName(addCustomerRequest.getName());
        customer.setEmail(addCustomerRequest.getEmail());
        customer.setPhone(addCustomerRequest.getPhone());
        customer.setBirth_date(addCustomerRequest.getBirth_date());
        customer.setGender(addCustomerRequest.getGender());

        customerRepository.save(customer);

    }

    @Override
    public GetCustomerResponse addCustomerWithCustomerInfo(AddCustomerRequest addCustomerRequest) {
        // return this.customerRepository.save(addCustomerRequest);
        // Mapping
        Customer customer = new Customer();

        customer.setName(addCustomerRequest.getName());
        customer.setEmail(addCustomerRequest.getEmail());
        customer.setPhone(addCustomerRequest.getPhone());
        customer.setBirth_date(addCustomerRequest.getBirth_date());
        customer.setGender(addCustomerRequest.getGender());

        Customer savedCustomer = customerRepository.save(customer);

        GetCustomerResponse getCustomerResponse = new GetCustomerResponse();

        getCustomerResponse.setId(savedCustomer.getId());
        getCustomerResponse.setName(savedCustomer.getName());
        getCustomerResponse.setPhone(savedCustomer.getPhone());
        getCustomerResponse.setEmail(savedCustomer.getEmail());
        getCustomerResponse.setBirth_date(savedCustomer.getBirth_date());

        return getCustomerResponse;
    }
}
