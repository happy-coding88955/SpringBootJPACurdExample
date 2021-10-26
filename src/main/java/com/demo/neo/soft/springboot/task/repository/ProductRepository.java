package com.demo.neo.soft.springboot.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.neo.soft.springboot.task.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	public String deleteProduct(Integer productId);
}
