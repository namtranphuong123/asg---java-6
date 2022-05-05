package poly.techshop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.techshop.dao.ProductDao;
import poly.techshop.entyti.Report;
import poly.techshop.service.ReportService;
@Service
public class ReportServiceImpl implements ReportService{
@Autowired
ProductDao dao;
	@Override
	public List<Report> getInventoryByCategory() {
		return dao.getInventoryByCategory();
	}

}
