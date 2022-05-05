package poly.techshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poly.techshop.entyti.Product;
import poly.techshop.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@RequestMapping("/product/list")
public String list(Model model,@RequestParam("cid")Optional<Integer> cid) {
		if(cid.isPresent()) {
			List<Product> list = productService.findByCategoryId(cid.get());
			model.addAttribute("items1",list);
		}
		else {
			
			List<Product> list1 = productService.findByCategoryId(1001);
			model.addAttribute("items1",list1);
			List<Product> list2 = productService.findByCategoryId(1005);
			model.addAttribute("items2",list2);
			List<Product> list3 = productService.findByCategoryId(1006);
			model.addAttribute("items3",list3);
			
		}
		
	return "product/list";
}
	
	@RequestMapping("/product/listPrice")
	public String listPrice(Model model,@RequestParam("cid")Optional<Integer> cid) {
			if(cid.isPresent()) {
				List<Product> list = productService.findByPrice(cid.get());
				model.addAttribute("items1",list);
			}
			else {
				
				List<Product> list1 = productService.findByCategoryId(1001);
				model.addAttribute("items1",list1);
				List<Product> list2 = productService.findByCategoryId(1005);
				model.addAttribute("items2",list2);
				List<Product> list3 = productService.findByCategoryId(1006);
				model.addAttribute("items3",list3);
				
			}
			
		return "product/list";
	}
	
	@RequestMapping("/product/detail/{id}")
public String detail(Model model, @PathVariable("id") Integer id) {
		Product item = productService.findById(id);
		model.addAttribute("item",item);
	return "product/detail";
} 
	
	@RequestMapping("/product/list/search")
	public String search(ModelMap model ,
			@RequestParam(name = "name", required = false)String name) {
		List<Product> list = null;
		if(StringUtils.hasText(name)) {
			list = productService.findByNameContaining(name);
			
		}else {
			list = productService.findAll();
			
		}
		model.addAttribute("items1",list);
		return "product/list";
	}
}
