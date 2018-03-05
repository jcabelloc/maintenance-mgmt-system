package edu.tamu.jcabelloc.maintsystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.tamu.jcabelloc.maintsystem.entity.Order;
import edu.tamu.jcabelloc.maintsystem.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("list")
	public String list(Model model) {
		List<Order> orders = orderService.getOrders();
		model.addAttribute(orders);
		return "orderList";
	}
	
	@GetMapping("addOrderForm")
	public String addOrderForm(Model model) {
		Order order = new Order();
		order.setRegisteredDate(LocalDate.now());
		model.addAttribute(order);
		return "orderForm";
	}
}
