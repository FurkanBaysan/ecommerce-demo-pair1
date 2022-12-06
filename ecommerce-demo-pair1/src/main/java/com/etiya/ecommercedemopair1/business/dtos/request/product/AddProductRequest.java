package com.etiya.ecommercedemopair1.business.dtos.request.product;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddProductRequest {

    @NotNull()
    @NotBlank(message = "name can not be null or empty")
    @Size(min = 3, max = 50, message = "name must be between 3 and 50 characters long")
    private String name;

    @Min(value = 1, message = "price can not be less than 1")
    private double unitPrice;

    @Min(value = 0, message = "Stok Adedi 0'dan kucuk olamaz")
    private int stock;
    private double discountRate;

    private int categoryId;
}
