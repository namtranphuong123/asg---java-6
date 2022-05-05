package poly.techshop.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.techshop.dao.AccountDao;
import poly.techshop.entyti.Account;
import poly.techshop.service.AccountsService;
@Service
public class AccountsServiceImpl implements AccountsService {
@Autowired
AccountDao dao;
@Autowired
AccountsService accdao;
	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Account findById(String username) {
		// TODO Auto-generated method stub
		return dao.findById(username).get();
	}

	@Override
	public Account create(Account account) {
		// TODO Auto-generated method stub
		return dao.save(account);
	}

	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		return dao.save(account);
	}

	@Override
	public void deleteById(String username) {
dao.deleteById(username);		
	}

	

	@Override
	public Optional<Account> findByIdedit(String username) {
		return dao.findById(username);
	}

	@Override
	public void save(Account entity) {
dao.save(entity)	;	
	}

	@Override
	public Account findByUsername(String username) {
		return dao.findByUsername(username);
	}

	@Override
	public List<Account> getAdministratos() {
		return dao.getAdministratos();
	}

	

}
