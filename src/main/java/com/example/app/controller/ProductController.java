package com.example.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Product;
import com.example.app.repository.ProductRepository;
//import com.example.app.response.ResponseEP;
//import com.example.app.service.ProductServices;

//import com.example.app.service.ProductServices;
import exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
//	@Autowired
//	private ProductServices service;
		
	@GetMapping("/product")
	public java.util.List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
//	@PostMapping("/product")
//	public ResponseEP newUser(@RequestBody Product product) {
//		ResponseEP res2 = null;
//		try {
//			// service + business logic
//			int checkProductID = product.getpID();
//			if (checkProductID != 0) {
//				Product userobj= service.checkproductid(checkProductID);
//					if (userobj != null) {
//						res2 = new ResponseEP();
//						res2.setMessageStringP("Product ID already exist");
//						res2.setStatusCode(500);
//						res2.setPid(userobj.getpID());
//					}else {
//						service.saveProduct(product);
//						res2 = new ResponseEP();
//						res2.setMessageStringP("Product saved successfully");
//						res2.setStatusCode(200);
//						res2.setPid(1);
//					}
//			}
//		}catch(Exception ex) {
//			// what is your error response
//			res2 = new ResponseEP();
//			res2.setMessageStringP("Error in user saving");
//			res2.setStatusCode(405);
//			res2.setPid(0);
//			
//		}
//		return res2;
//	}
	
	@GetMapping("/product/{pID}")
	public ResponseEntity<Product> getProductByID(@PathVariable int pID) {
		Product product = productRepository.findById(pID).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		return ResponseEntity.ok(product);
	}
	
	@PutMapping("/product/{pID}")
	public ResponseEntity<Product> updateProduct(@PathVariable int pID, @RequestBody Product productDetails){
		Product product = productRepository.findById(pID).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		
		product.setpName(productDetails.getpName());
		product.setPrice(productDetails.getPrice());
		product.setQty(productDetails.getQty());
		
		Product updatedProduct = productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	@DeleteMapping("/product/{pID}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable int pID){
		Product product = productRepository.findById(pID).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
		
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted Product", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
