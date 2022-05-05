package poly.techshop.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	@RequestMapping({"/","/home/index"})
	public String home() {
		
		return "redirect:/product/list";
	}
	@RequestMapping({"/dangky","/home/index/dangky"})
	public String dangky() {
		
		return "redirect:/account";
	}
	
	@RequestMapping({"/admin","/admin/home/index"})
	public String admin() {
		
		return "redirect:/assert/admin/index.html";
	}
}
