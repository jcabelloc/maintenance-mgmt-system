package edu.tamu.jcabelloc.maintsystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		model.addAttribute("orders", orders);
		return "orderList";
	}
	
	@GetMapping("addOrderForm")
	public String addOrderForm(Model model) {
		Order order = new Order();
		order.setStatus('A');
		order.setRegisteredDate(LocalDate.now());
		model.addAttribute(order);
		return "orderForm";
	}
	@PostMapping("/saveOrder")
	public String saveOrder(@ModelAttribute("order") Order order) {
		orderService.saveOrder(order);
		return "redirect:/order/list";
	}
	@GetMapping("/updateOrderForm")
	public String updateOrderForm(@RequestParam("orderId") int orderId, Model model) {
		Order order = orderService.getOrder(orderId);
		model.addAttribute("order", order);
		return "orderForm";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("orderId") int orderId) {
		orderService.deleteOrder(orderId);
		return "redirect:/order/list";
	}
}
