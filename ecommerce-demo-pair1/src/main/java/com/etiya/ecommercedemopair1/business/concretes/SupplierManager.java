package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.SupplierService;
import com.etiya.ecommercedemopair1.business.dtos.request.supplier.AddSupplierRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.supplier.GetSupplierResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Supplier;
import com.etiya.ecommercedemopair1.repository.abstracts.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierManager implements SupplierService {

    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierManager(SupplierRepository supplierRepository) { // Dependency Injection
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void addSupplier(AddSupplierRequest addSupplierRequest) {
        // Matching
        Supplier supplier = new Supplier();
        supplier.setName(addSupplierRequest.getName());
        supplier.setEmail(addSupplierRequest.getEmail());
        supplier.setPhone(addSupplierRequest.getPhone());
        supplier.setBirth_date(addSupplierRequest.getBirth_date());
        supplier.setDescription(addSupplierRequest.getDescription());

        supplierRepository.save(supplier);
    }

    @Override
    public GetSupplierResponse getSupplierWithInfo(AddSupplierRequest addSupplierRequest) {
        // Matching
        Supplier supplier = new Supplier();
        supplier.setName(addSupplierRequest.getName());
        supplier.setEmail(addSupplierRequest.getEmail());
        supplier.setPhone(addSupplierRequest.getPhone());
        supplier.setBirth_date(addSupplierRequest.getBirth_date());
        supplier.setDescription(addSupplierRequest.getDescription());

        supplierRepository.save(supplier);

        GetSupplierResponse getSupplierResponse = new GetSupplierResponse(supplier.getEmail(), supplier.getName(),
                supplier.getPhone(),
                supplier.getBirth_date(),
                supplier.getDescription());

        return getSupplierResponse;

    }
}
