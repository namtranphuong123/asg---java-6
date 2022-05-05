package poly.techshop.service;

import java.util.List;

import poly.techshop.entyti.Category;

public interface CategoryService {

	List<Category> findAll();

	Category findById(Integer id);

	Category create(Category category);

	Category update(Category category);

	void deleteById(Integer id);

}
