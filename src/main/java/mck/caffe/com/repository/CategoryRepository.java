package mck.caffe.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mck.caffe.com.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
