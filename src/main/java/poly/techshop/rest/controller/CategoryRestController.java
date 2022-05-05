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
import poly.techshop.service.CategoryService;
import poly.techshop.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
	@Autowired
	CategoryService categorySevice;

	@GetMapping()
	public List<Category> getAll() {
		return categorySevice.findAll();
	}
	
	
	

	@GetMapping("{id}")
	public Category getOne(@PathVariable("id") Integer id) {
		return categorySevice.findById(id);
	}

	@PostMapping
	public Category create(@RequestBody Category category) {
		return categorySevice.create(category);
	}
	
	@PutMapping("{id}")
	public Category update(@PathVariable("id") Integer id, @RequestBody Category category) {
		return categorySevice.update(category);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		categorySevice.deleteById(id);
	}

	

}
