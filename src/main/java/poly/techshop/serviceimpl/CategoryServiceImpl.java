package poly.techshop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.techshop.dao.CategoryDao;
import poly.techshop.entyti.Category;
import poly.techshop.entyti.Product;
import poly.techshop.service.CategoryService;
@Service

public class CategoryServiceImpl implements  CategoryService{
@Autowired
CategoryDao dao;
	@Override
	public List<Category> findAll() {
		
		return dao.findAll();
	}
	@Override
	public Category findById(Integer id) {
		return dao.findById(id).get();
	}
	@Override
	public Category create(Category category) {
		return dao.save(category);
	}
	@Override
	public Category update(Category category) {
		return dao.save(category);

	
	}
	@Override
	public void deleteById(Integer id) {
		 dao.deleteById(id);		
	}
	

}
