package mck.caffe.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mck.caffe.com.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository <Products, Long> {
	public List<Products> findAllByNameContainingIgnoreCase(@Param("name") String name);
	
		public Products findProductByName(@Param("name") String name);

}