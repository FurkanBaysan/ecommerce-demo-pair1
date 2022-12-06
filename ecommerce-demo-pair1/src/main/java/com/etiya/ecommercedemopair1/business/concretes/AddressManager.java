package com.etiya.ecommercedemopair1.business.concretes;

import com.etiya.ecommercedemopair1.business.abstracts.AddressService;
import com.etiya.ecommercedemopair1.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemopair1.business.dtos.response.address.GetAddressResponse;
import com.etiya.ecommercedemopair1.entities.concretes.*;
import com.etiya.ecommercedemopair1.repository.abstracts.AddressRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.CityRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.CountryRepository;
import com.etiya.ecommercedemopair1.repository.abstracts.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressManager implements AddressService {

    private AddressRepository addressRepository;
    private UserRepository userRepository;
    private CityRepository cityRepository;
    private CountryRepository countryRepository;


    @Autowired
    public AddressManager(AddressRepository addressRepository, UserRepository userRepository, CityRepository cityRepository,
                          CountryRepository countryRepository) { // Dependency Injection
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Address> getAll() {
        return this.addressRepository.findAll();
    }

    @Override
    public void addAddress(Address address) {
        //this.addressRepository.save(address);
    }

    @Override
    public void addAddressInfo(AddAddressRequest addAddressRequest) {
        // Mapping - > map the attributes from the request to the attributes of the object we created ourselves.
        Address address = new Address();

        //address.getUser().setId(addAddressRequest.getUser());
        //address.getCity().setId(addAddressRequest.getCity());
        //address.getCountry().setId(addAddressRequest.getCountry());

        address.setStreet(addAddressRequest.getStreet());
        address.setTitle(addAddressRequest.getTitle());
        address.setPostalcode(addAddressRequest.getPostalcode());
        address.setUser(userRepository.findById(addAddressRequest.getUserId()));
        address.setCity(cityRepository.findById(addAddressRequest.getCityId()));
        address.setCountry(countryRepository.findById(addAddressRequest.getCountryId()));

        this.addressRepository.save(address);


    }

    @Override
    public GetAddressResponse getAddressWithInfo(AddAddressRequest addAddressRequest) {
        Address address = new Address();
        address.setStreet(addAddressRequest.getStreet());
        address.setTitle(addAddressRequest.getTitle());
        address.setPostalcode(addAddressRequest.getPostalcode());

        address.setUser(userRepository.findById(addAddressRequest.getUserId()));

        checkUserExists(addAddressRequest.getUserId());

        address.setCity(cityRepository.findById(addAddressRequest.getCityId()));

        checkCityExists(addAddressRequest.getCityId());

        address.setCountry(countryRepository.findById(addAddressRequest.getCountryId()));

        checkCountryExists(addAddressRequest.getCountryId());

        addressRepository.save(address);

        GetAddressResponse getAddressResponse = new GetAddressResponse(address.getPostalcode(), address.getStreet(), address.getTitle(),
                address.getUser().getId(), address.getCity().getId(), address.getCountry().getId());

        return getAddressResponse;
    }

    private void checkUserExists(int id) {

        boolean isExist = userRepository.existsById(id);
        if (!isExist) {
            throw new RuntimeException("This user doesn't exist");
        }
    }

    private void checkCityExists(int id) {

        boolean isExist = cityRepository.existsById(id);
        if (!isExist) {
            throw new RuntimeException("This city doesn't exist");
        }
    }

    private void checkCountryExists(int id) {

        boolean isExist = countryRepository.existsById(id);
        if (!isExist) {
            throw new RuntimeException("This country doesn't exist");
        }
    }


}
