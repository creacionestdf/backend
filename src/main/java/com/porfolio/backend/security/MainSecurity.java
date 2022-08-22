package com.porfolio.backend.security;

import com.porfolio.backend.security.jwt.JwtEntryPoint;
import com.porfolio.backend.security.jwt.JwtTokenFilter;
import com.porfolio.backend.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class MainSecurity extends WebSecurityConfigurerAdapter{
public class MainSecurity {
	@Autowired
	UserDetailsImpl userDetailsService;
	
	@Autowired
	JwtEntryPoint jwtEntryPoint;
	

    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean(); 
    }
    
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager(); 
    }
*/
    
    //@Override
    //protected void configure(HttpSecurity http) throws Exception {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/auth/**").permitAll()//permitimos el acceso a /auth a cualquiera
                .antMatchers("/acercade/**").hasAuthority("ADMIN")
                .anyRequest().authenticated() //cualquier otra peticion requiere autenticacion
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        //Las demas peticiones pasaran por este filtro para validadr el token
        
        http.addFilterBefore(jwtTokenFilter(), 
        		UsernamePasswordAuthenticationFilter.class);
        //  http.headers().frameOptions().sameOrigin();
        http.headers().frameOptions().sameOrigin();
        
        // return http.build();
        return http.build();
    }

	
	
}
