package poly.techshop.serviceimpl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import poly.techshop.dao.OrderDao;
import poly.techshop.dao.OrderDetailDao;
import poly.techshop.entyti.Order;
import poly.techshop.entyti.OrderDetail;
import poly.techshop.entyti.Product;
import poly.techshop.service.OrderService;
@Service
public class OrderServiceImpl implements  OrderService{
@Autowired
OrderDao dao;
@Autowired
OrderDetailDao ddao;


	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper =  new ObjectMapper();
		Order order = mapper.convertValue(orderData, Order.class);
		dao.save(order);
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		ddao.saveAll(details);
		return order;
	}


	@Override
	public Order findById(Integer id) {
		//vi la op
		return dao.findById(id).get();
	}


	@Override
	public List<Order> findByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.finByUsername(username);
	}


	@Override
	public List<Order> findAll() {
		return dao.findAll();
	}


	@Override
	public void deleteById(Integer id) {
dao.deleteById(id);		
	}


	

	@Override
	public Order update(Order order) {
		// TODO Auto-generated method stub
		return dao.save(order);
	}

}
