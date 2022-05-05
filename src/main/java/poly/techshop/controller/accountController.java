package poly.techshop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.techshop.service.AccountsService;

@Controller
public class accountController {
	@Autowired
	AccountsService accountService;
	@RequestMapping("/account")
	public String dangky() {
		return "/account/form";
	}
	
	
	
}
