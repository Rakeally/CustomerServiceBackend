
package com.CallCenter.master.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired 
	private UserDetailsService userDetailsService;
	
	@Primary
	@Override 
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService) .passwordEncoder(passwordEncoder());
	
	}
	
 @Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf()
			.disable() // don't create session
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests() 
			.antMatchers(
					HttpMethod.GET,
		              "/",
		              "/v2/api-docs",           // swagger
		              "/webjars/**",            // swagger-ui webjars
		              "/swagger-resources/**",  // swagger-ui resources
		              "/configuration/**",      // swagger configuration
		              "/*.html",                
		              "/favicon.ico",
		              "/**/*.html",
		              "/**/*.css",
		              "/**/*.js",
		              "/csrf", 
		              "/configuration/ui", 
		              "/swagger-ui.html",
		              "/login/**",
		              "/login"
		              
		              )
			.permitAll() 
		    .antMatchers("/",
		              "/forgotPass/{email}",
		              "/customer/create",
		              "/activateUserAccount/{token}",
		              "/countUsers",
		              "/reset"
		              ).permitAll()
				
			.antMatchers("/tasks/**"
					,"/employee/create",
					"/employee/list",
					"/claim/deleteById/{claimId}",
					"/signupAdmin"
					).hasAuthority("ADMIN")

//
		    .anyRequest()
			.authenticated() 
			.and()
			.addFilter(new JWTAuthenticationFilter(authenticationManager()))
			.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
		}
	
}

//push sail ordinary pair prepare advice trumpet capital local mango number glass cruise such wealth scare clutch time evoke absorb nest august wisdom civil
