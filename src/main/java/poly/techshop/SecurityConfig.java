package poly.techshop;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import poly.techshop.entyti.Account;
import poly.techshop.service.AccountsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
@Autowired
AccountsService accountService;
@Autowired
BCryptPasswordEncoder pe;

// cung cấp nguồn dữ liệu đăng nhập
//AuthenticationManagerBuilder ddeer dduwa nguoonf duwx lieeuj vaof
protected void configure(AuthenticationManagerBuilder auth)throws Exception {
	auth.userDetailsService(username -> {
		try {
			Account user = accountService.findById(username);
			String password = pe.encode(user.getPassword());
			String [] roles = user.getAuthorities().stream()
					.map(er -> er.getRole().getId())
					.collect(Collectors.toList()).toArray(new String[0]);
			return User.withUsername(username).password(password).roles(roles).build();
			
		} catch (NoSuchElementException e) {
throw new UsernameNotFoundException(username + "Not found !");

		}
	});
	
	
//	auth.userDetailsService(username ->{
//		try {
//			Account user = accountService.findById(username).get();
//			String password = pe.encode(user.getPassword());
//			String[] roles = user.getAuthorities().stream()
//					.map(er ->er.getRole().getId())
//					.collect(Collectors.toList()).toArray(new String[0]);
//			return User.withUsername(username).password(password).roles(roles).build();
//			
//		} catch (NoSuchElementException e) {
//			// TODO: handle exception
//			throw new UsernameNotFoundException(username + "not found");
//		}
//		
//	});
}





protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable();
	http.authorizeRequests()
	.antMatchers("/order/**").authenticated()
	.antMatchers("/admin/**").hasAnyRole("STAF","DIER")
	.antMatchers("/rest/authorities").hasRole("DIRE")
	.anyRequest().permitAll();
	 http.formLogin()
	 .loginPage("/security/login/form")
	 .loginProcessingUrl("/security/login")
	 .defaultSuccessUrl("/security/login/success",false)
	 .failureUrl("/security/login/error");
	 
	 http.rememberMe()
	 .tokenValiditySeconds(86400);
	  http.exceptionHandling()
	  .accessDeniedPage("/security/unauththoried");
	  
	  http.logout()
	  .logoutUrl("/security/logoff")
	  .logoutSuccessUrl("/security/logoff/success");
	  
}
@Bean
public BCryptPasswordEncoder getPasswordEncoder() {
	return new BCryptPasswordEncoder();
	
}
@Override
public void configure(WebSecurity web) throws Exception{
	web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
	
}
}
