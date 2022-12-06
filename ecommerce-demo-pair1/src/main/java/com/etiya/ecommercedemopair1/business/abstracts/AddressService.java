package com.etiya.ecommercedemopair1.business.abstracts;


import com.etiya.ecommercedemopair1.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.address.GetAddressResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Address;

import java.util.List;

public interface AddressService {
    public List<Address> getAll();

    public void addAddress(Address address);

    public void addAddressInfo(AddAddressRequest addAddressRequest);

    public GetAddressResponse getAddressWithInfo(AddAddressRequest addAddressRequest);
}
