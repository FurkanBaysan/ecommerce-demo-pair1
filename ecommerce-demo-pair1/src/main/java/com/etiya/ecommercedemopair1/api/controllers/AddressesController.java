package com.etiya.ecommercedemopair1.api.controllers;

import com.etiya.ecommercedemopair1.business.abstracts.AddressService;
import com.etiya.ecommercedemopair1.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.address.GetAddressResponse;
import com.etiya.ecommercedemopair1.entities.concretes.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Address")
public class AddressesController {
    private AddressService addressService;

    @Autowired
    public AddressesController(AddressService addressService) { // Dependency Injection
        this.addressService = addressService;
    }

    @GetMapping("/getAllAddresses")
    public List<Address> getAll() {
        return this.addressService.getAll();
    }

    @PostMapping("/addAddress")
    public void addAddress(@RequestBody Address address) {
        //this.addressService.addAddress(address);
    }

    @PostMapping("/addAddressWithInfo")
    public void addAddressWithInfo(@RequestBody AddAddressRequest addAddressRequest) {
        this.addressService.addAddressInfo(addAddressRequest);
    }

    @PostMapping("addAddressGetInfo")
    public ResponseEntity<GetAddressResponse> addAddressGetInfo(@RequestBody AddAddressRequest addAddressRequest) {
        return new ResponseEntity<GetAddressResponse>(this.addressService.getAddressWithInfo(addAddressRequest), HttpStatus.CREATED);
    }

}
