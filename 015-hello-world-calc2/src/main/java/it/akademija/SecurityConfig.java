package it.akademija;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityEntryPoint securityEntryPoint;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("uu").password("pp").roles("USER", "CALC");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/swagger-ui.html").permitAll().antMatchers("/api/**", "/calc/**")
				.authenticated().and().formLogin().successHandler(new SimpleUrlAuthenticationSuccessHandler() {

					@Override
					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
							Authentication authentication) throws IOException, ServletException {
						response.setHeader("Access-Control-Allow-Credentials", "true");
						response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
						response.setHeader("Content-Type", "application/json;charset=UTF-8");
						response.getWriter().print("{\"username\": \""
								+ SecurityContextHolder.getContext().getAuthentication().getName() + "\"}");
					}

				}).failureHandler(new SimpleUrlAuthenticationFailureHandler()).loginPage("/login").permitAll().and()
				.logout().permitAll().and().csrf().disable().exceptionHandling()
				.authenticationEntryPoint(securityEntryPoint).and().headers().frameOptions().disable();
	}

}
