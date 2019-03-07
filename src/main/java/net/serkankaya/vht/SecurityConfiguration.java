package net.serkankaya.vht;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/**/favicon.ico", "/css/**", "/js/**", "/images/**", "/webjars/**", "/login.html").permitAll();
		http.authorizeRequests().antMatchers("/actuator/**").access("hasRole('ADMIN')");
//		http.authorizeRequests().antMatchers("/sahip/guncelle/**").access("hasRole('ADMIN')");
		http.authorizeRequests().anyRequest().authenticated();
		http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").failureUrl("/login.html?loginFailed=true");
		http.rememberMe().userDetailsService(userDetailsService);
		http.httpBasic();
		http.csrf().disable();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

}
