package poly.techshop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.techshop.dao.StatusDao;
import poly.techshop.entyti.Status;
import poly.techshop.service.StatusService;
@Service
public class StatusServiceImpl implements StatusService{
@Autowired
StatusDao dao;
	@Override
	public List<Status> findAll() {
		return dao.findAll() ;
	}

}
