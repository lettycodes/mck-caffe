package mck.caffe.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.http.HttpStatus;*/
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mck.caffe.com.model.Products;
import mck.caffe.com.repository.ProductsRepository;
import mck.caffe.com.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductsRepository productsRepository; 
	
	@Autowired
	private ProductsService productsService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Products>> getAll() {
		return ResponseEntity.ok(productsRepository.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Products> findById(@PathVariable Long id) {
		Products obj = productsService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*@GetMapping("/{id}")
	public ResponseEntity<Products> getById(@PathVariable Long id) {
		return productsRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}*/

}
