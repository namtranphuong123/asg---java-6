package poly.techshop.service;

import java.util.List;
import java.util.Optional;

import poly.techshop.entyti.Account;
import poly.techshop.entyti.Product;

public interface AccountsService {

	List<Account> findAll();

	Account findById(String username);

	Account create(Account account);

	Account update(Account account);

	void deleteById(String username);


	Optional<Account> findByIdedit(String username);

	void save(Account entity);

	Account findByUsername(String username);

	public List<Account> getAdministratos();

	



}
