package poly.techshop.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.techshop.dao.ProductDao;
import poly.techshop.entyti.Product;
import poly.techshop.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
@Autowired
ProductDao dao;

	@Override
	public List<Product> findAll() {
		
		return dao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		return dao.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryId(Integer cid) {
		return dao.findByCategoryId(cid);
	}

	@Override
	public List<Product> findByNameLike(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByNameContaining(String name) {
		return dao.findByNameContaining(name);
	}

	@Override
	public List<Product> findByPrice(Integer cid) {
		// TODO Auto-generated method stub
		return dao.findByPrice(cid);
	}

	@Override
	public Product create(Product product) {
		return dao.save(product);
	}

	@Override
	public Product update(Product product) {
		return dao.save( product);
	}

	@Override
	public void deleteById(Integer id) {
		 dao.deleteById(id);
	}

	






	

	


}
