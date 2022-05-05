package poly.techshop.service;

import java.util.List;

import poly.techshop.entyti.Account;
import poly.techshop.entyti.Authority;

public interface AuthoritiesSevice {


	public List<Authority> findAll();

	public Authority create(Authority auth);

	public void delete(Integer id);


	public List<Authority> findAuthoritiesOfAdministrator();

}
