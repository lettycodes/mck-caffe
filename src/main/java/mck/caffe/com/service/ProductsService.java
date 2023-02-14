package mck.caffe.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mck.caffe.com.model.Products;
import mck.caffe.com.repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productsRepository;

	public List<Products> findAll() {
		return productsRepository.findAll();
	}

	public Products findById(Long id) {
		Optional<Products> obj = productsRepository.findById(id);
		return obj.get();
	}
}
