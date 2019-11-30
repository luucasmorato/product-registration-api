package com.products.apirest.resources;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.products.apirest.models.Product;
import com.products.apirest.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//Controller Products
//Contains product CRUD

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="Products API REST")
public class ProductResource {
	
	@Autowired
	ProductRepository productRepository;
	
	@ApiOperation(value="Returns a product list")
	@GetMapping("/products")
	public List<Product> listProducts(){
		return productRepository.findAll();
	}
	
	@ApiOperation(value="Returns a unique product")
	@GetMapping("/product/{id}")
	public Product listProductUnique(@PathVariable(value="id") long id){
		return productRepository.findById(id);
	}
	
	@ApiOperation(value="Save a product")
	@PostMapping("/product")
	public Product saveProduct(@RequestBody @Valid Product product) {
		return productRepository.save(product);
	}
	
	@ApiOperation(value="Delete a product")
	@DeleteMapping("/product")
	public void deletaProduto(@RequestBody @Valid Product product) {
		productRepository.delete(product);
	}
	
	@ApiOperation(value="Update a product")
	@PutMapping("/product")
	public Product updateProduct(@RequestBody @Valid Product product) {
		return productRepository.save(product);
	}
	 
}