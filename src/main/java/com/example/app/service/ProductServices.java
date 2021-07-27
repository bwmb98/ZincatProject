//package com.example.app.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.app.model.Product;
//import com.example.app.repository.ProductRepository;
//
//@Service
//
//public class ProductServices {
//
//	@Autowired
//	
//	private ProductRepository repo;
//	
//	public Product saveProduct(Product product) {
//		
//		return repo.save(product);
//	}
//	
//	public Product checkproductid(int pID) {
//		return repo.findByProductID(pID);
//	}
//	
//}
