package poly.techshop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import poly.techshop.entyti.Account;

public interface AccountDao extends JpaRepository<Account, String>{

	Account findByUsername(String username);
@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('DIRE','STAF','CUST')")
	List<Account> getAdministratos();

}
