package mck.caffe.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import mck.caffe.com.model.Order;
import mck.caffe.com.repository.OrderRepository;
import mck.caffe.com.service.exceptions.DatabaseException;
import mck.caffe.com.service.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = orderRepository.findById(id);
		return obj.get();
	}
	
	public Order insert(Order obj) {
		return orderRepository.save(obj);
	}
	
	public Order update(Long id, Order obj) {
		try {
			Order entity = orderRepository.getReferenceById(id);
			updateData(entity, obj);
			return orderRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}
	
	private void updateData(Order entity, Order obj) {
		entity.setId(obj.getId());
		entity.setOrderStatus(obj.getOrderStatus());
		entity.setClientName(obj.getClientName());
	}
	
	public void delete(Long id) {
		try {
			orderRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
