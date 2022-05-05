package poly.techshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import poly.techshop.entyti.OrderDetail;


public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer>{

}
