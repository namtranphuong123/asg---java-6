package poly.techshop.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import poly.techshop.entyti.Category;
import poly.techshop.entyti.Order;

public interface OrderService {

	Order create(JsonNode orderData);

	Order findById(Integer id);

	List<Order> findByUsername(String username);

	List<Order> findAll();

	void deleteById(Integer id);

	Order update(Order order);

	

}
