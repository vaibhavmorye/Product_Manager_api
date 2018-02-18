package com.ngboot.CURD_example_ng_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngboot.CURD_example_ng_boot.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
  Product findByproductId(Integer id);
 

}
