package poly.techshop.service;

import java.util.List;
import java.util.Optional;

import poly.techshop.entyti.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(Integer cid);

	List<Product> findByNameLike(String name);

	List<Product> findByNameContaining(String name);

	List<Product> findByPrice(Integer cid);

	Product  create(Product product);

	Product update(Product product);


	void deleteById(Integer id);


	






	

	

}
