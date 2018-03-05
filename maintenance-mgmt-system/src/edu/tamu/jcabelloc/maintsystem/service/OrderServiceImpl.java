package edu.tamu.jcabelloc.maintsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tamu.jcabelloc.maintsystem.entity.Order;
import edu.tamu.jcabelloc.maintsystem.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepository;	
	
	@Override
	@Transactional
	public List<Order> getOrders() {
		return orderRepository.getOrders();
	}

	@Override
	@Transactional
	public Order getOrder(int orderId) {
		return orderRepository.getOrder(orderId);
	}

	@Override
	@Transactional
	public void saveOrder(Order order) {
		orderRepository.saveOrder(order);
	}

	@Override
	@Transactional
	public void deleteOrder(int orderId) {
		orderRepository.deleteOrder(orderId);
	}
}
