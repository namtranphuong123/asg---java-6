package poly.techshop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.techshop.dao.AccountDao;
import poly.techshop.dao.AuthorityDao;
import poly.techshop.entyti.Account;
import poly.techshop.entyti.Authority;
import poly.techshop.service.AccountsService;
import poly.techshop.service.AuthoritiesSevice;
@Service
public class AuthoritiesSeviceImpl implements AuthoritiesSevice{
	@Autowired
	AuthorityDao authorityDAO;
	
	@Autowired
	AccountDao accountDAO;
	

	@Override
	public List<Authority> findAll() {
		return authorityDAO.findAll();
	}

	@Override
	public Authority create(Authority auth) {
		return authorityDAO.save(auth);
	}


	@Override
	public void delete(Integer id) {
		authorityDAO.deleteById(id);
	}

	@Override
	public List<Authority> findAuthoritiesOfAdministrator() {
List<Account> accounts = accountDAO.getAdministratos();
return authorityDAO.authoritiesOf(accounts);
	}


	
}
