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

import poly.techshop.entyti.Category;
import poly.techshop.entyti.Product;
import poly.techshop.entyti.Role;
import poly.techshop.service.CategoryService;
import poly.techshop.service.ProductService;
import poly.techshop.service.RoleService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RolesRestController {
	@Autowired
	RoleService roleSevice;

	@GetMapping()
	public List<Role> getAll() {
		return roleSevice.findAll();
	}
	
	
	
}
