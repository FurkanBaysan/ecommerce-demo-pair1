package com.etiya.ecommercedemopair1.repository.abstracts;

import com.etiya.ecommercedemopair1.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
    public City findById(int id);

    public boolean existsById(int id);
}
