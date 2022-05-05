package poly.techshop.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import poly.techshop.entyti.Category;
import poly.techshop.entyti.Order;
import poly.techshop.entyti.Product;
import poly.techshop.service.OrderService;
import poly.techshop.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
	@Autowired
	OrderService orderService;

	
	@GetMapping()
	public List<Order> getAll() {
		return orderService.findAll();
	}
	@PostMapping()
	// vif suwr dungj json nen dung request body
	public Order create(@RequestBody JsonNode orderData) {

	return orderService.create(orderData);
	}
	
	
	@GetMapping("{id}")
	public Order getOne(@PathVariable("id") Integer id) {
		return orderService.findById(id);
	}
	
	
	
	@PutMapping("{id}")
	public Order update(@PathVariable("id") Integer id, @RequestBody Order order) {
		return orderService.update(order);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		orderService.deleteById(id);
	}

}
