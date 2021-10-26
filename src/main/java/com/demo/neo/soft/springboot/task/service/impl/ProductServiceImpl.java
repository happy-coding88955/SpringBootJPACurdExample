package com.demo.neo.soft.springboot.task.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.neo.soft.springboot.task.entity.Product;
import com.demo.neo.soft.springboot.task.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl {

	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Product addProduct(Product product) {
		return productRepository.save(product);
		
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
		
	}
	public String removeProduct(Integer productId) {
		return "Product removed in list:"+productId;
		
	}
	public String deleteProduct(Integer productId) {
		
	     return productRepository.deleteProduct(productId);
		
	}
}
