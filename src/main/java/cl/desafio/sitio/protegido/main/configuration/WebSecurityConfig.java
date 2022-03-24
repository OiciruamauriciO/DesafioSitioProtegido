package cl.desafio.sitio.protegido.main.configuration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	private CustomAuthenticationSuccessHandler authenticationSuccessHandler;			

	public WebSecurityConfig(CustomAuthenticationSuccessHandler authenticationSuccessHandler) {
		this.authenticationSuccessHandler = authenticationSuccessHandler;
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/admin/**").hasAuthority("ADMIN")
		.antMatchers("/client/**").hasAuthority("CLIENT")
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.successHandler(authenticationSuccessHandler)
		.failureUrl("/login?error=true")
		.usernameParameter("email")
		.passwordParameter("password")
		.defaultSuccessUrl("/index")		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/recurso-prohibido");
	}
			
	/*
	 * .antMatchers("/admin/**").hasAuthority("ADMIN")
	 * .antMatchers("/client/**").hasAuthority("CLIENT")
	 */
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}	 
}