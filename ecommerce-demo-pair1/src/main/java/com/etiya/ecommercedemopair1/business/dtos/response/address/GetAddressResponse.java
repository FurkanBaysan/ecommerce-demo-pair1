package com.etiya.ecommercedemopair1.business.dtos.response.address;

import com.etiya.ecommercedemopair1.entities.concretes.City;
import com.etiya.ecommercedemopair1.entities.concretes.Country;
import com.etiya.ecommercedemopair1.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressResponse {

    private int postalcode;
    private String street;
    private String title;
    private int userId;
    private int cityId;
    private int countryId;
}
