package poly.techshop.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.techshop.dao.ProductDao;
import poly.techshop.entyti.Product;
import poly.techshop.entyti.Report;
import poly.techshop.service.ReportService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/report")
public class ReportRestController {
	@Autowired
		ProductDao dao;

	@GetMapping()
	public List<Report> getAll() {
		return dao.getInventoryByCategory();
	}
	@GetMapping("/a")
	public List<Report>getAlls() {
		return dao.revenueByCategory();
	}
	@GetMapping("/b")
	public List<Report>getAllss() {
		return dao.revenueByProduct();
	}
}
