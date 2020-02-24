package com.versionOne.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.versionOne.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
