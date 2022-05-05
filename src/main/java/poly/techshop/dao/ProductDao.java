package poly.techshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.techshop.entyti.Product;
import poly.techshop.entyti.Report;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
@Query("SELECT p FROM Product p WHERE p.category.id=?1")
	List<Product> findByCategoryId(Integer cid);
	
List<Product> findByNameContaining(String name);

@Query("SELECT p FROM Product p WHERE p.price=?1")
List<Product> findByPrice(Integer cid);


@Query("SELECT new Report(o.category, sum(o.price), count(o)) "
		+ " FROM Product o "
		+ " GROUP BY o.category"
		+ " ORDER BY sum(o.price) DESC")
		List<Report> getInventoryByCategory();

@Query("SELECT new Report(o.product.category, sum(o.price*o.quantity), sum(o.quantity)) FROM OrderDetail o GROUP BY o.product.category")
		List<Report> revenueByCategory();

@Query("SELECT   new Report (o.product, sum(o.price*o.quantity),sum(o.quantity)) FROM OrderDetail o GROUP BY o.product ORDER BY sum(o.price*o.quantity) DESC")
List<Report> revenueByProduct();


}
