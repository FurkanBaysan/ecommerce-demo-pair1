package com.etiya.ecommercedemopair1.business.dtos.request.address;

import com.etiya.ecommercedemopair1.entities.concretes.City;
import com.etiya.ecommercedemopair1.entities.concretes.Country;
import com.etiya.ecommercedemopair1.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddAddressRequest {
    private int postalcode;
    private String street;
    private String title;


    //private User user;
    //private City city;
    //private Country country;
    @Min(value = 0)
    private int userId;
    @Min(value = 0)
    private int cityId;
    @Min(value = 0)
    private int countryId;


}
