package poly.techshop.controller;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import poly.techshop.service.OrderService;
@Controller
public class orderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/order/checkout")
public String checkout() {
	return "order/checkout";
}
	@RequestMapping("/order/list")
	public String list(Model model,HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("order",orderService.findByUsername(username));

		return "order/list";
	}
	
	
	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("order",orderService.findById(id));
		return "order/detail";
	}
	

}
