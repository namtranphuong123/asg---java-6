package poly.techshop.rest.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poly.techshop.entyti.Account;
import poly.techshop.entyti.Product;
import poly.techshop.service.AccountsService;
import poly.techshop.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountsService accountService;

	@GetMapping("{id}")
	public Account getOne(@PathVariable("username") String username) {
		return accountService.findById(username);
	}

	@GetMapping()
	public List<Account> getAccount(@RequestParam("admin") Optional<Boolean> admin) {
		if (admin.orElse(false)) {
			return accountService.getAdministratos();
		}
		return accountService.findAll();

	}

	@PostMapping
	public Account create(@RequestBody Account account) {
		
		return accountService.create(account);
	}

	@PutMapping("{username}")
	public Account update(@PathVariable("username") String username, @RequestBody Account account) {
		return accountService.update(account);
	}

			
	@DeleteMapping("{username}")
	public void delete(@PathVariable("username") String username) {
		accountService.deleteById(username);
	}
}
