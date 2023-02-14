package mck.caffe.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mck.caffe.com.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
