package poly.techshop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.techshop.dao.RoleDao;
import poly.techshop.entyti.Role;
import poly.techshop.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
@Autowired
RoleDao dao;
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
