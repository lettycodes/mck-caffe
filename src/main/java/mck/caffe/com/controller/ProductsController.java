package mck.caffe.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mck.caffe.com.model.Products;
import mck.caffe.com.repository.ProductsRepository;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductsRepository productsRepository; 
	
	@GetMapping
	public ResponseEntity<List<Products>> getAll() {
		return ResponseEntity.ok(productsRepository.findAll());
	}

}
