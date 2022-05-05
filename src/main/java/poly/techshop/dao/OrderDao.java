package poly.techshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.techshop.entyti.Order;

	public interface OrderDao extends JpaRepository<Order,Integer >{
@Query("SELECT o FROM Order o WHERE o.account.username=?1")
		List<Order> finByUsername(String username);

}
