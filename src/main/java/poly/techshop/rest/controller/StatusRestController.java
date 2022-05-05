package poly.techshop.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poly.techshop.entyti.Status;
import poly.techshop.service.StatusService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/status")
public class StatusRestController {
	@Autowired
	StatusService statusSevice;

	@GetMapping()
	public List<Status> getAll() {
		return statusSevice.findAll();
	}

}
