/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Secuirity;


import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Soufiane
 */
@Configuration
public class SecuirityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource; 
    @Autowired
    private UserDetailsService userServiceD; 
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        PasswordEncoder pe=bcrypt();
        System.out.println("pass= "+pe.encode("1234"));
        /*auth.inMemoryAuthentication().withUser("user1").password(pe.encode("1234")).roles("USER");
        auth.inMemoryAuthentication().withUser("user2").password(pe.encode("1234")).roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password(pe.encode("1234")).roles("USER","ADMIN");*/
        
//        auth.jdbcAuthentication()
//             .dataSource(dataSource)
//             .usersByUsernameQuery("select username as principal, password as credentials, active from users where username=?")
//             .authoritiesByUsernameQuery("select username as principal, role as role from users_roles where username=?")
//             .passwordEncoder(pe)
//             .rolePrefix("ROLE_");
         auth.userDetailsService(userServiceD).passwordEncoder(pe);
            
    }
 
    protected  void configure(HttpSecurity http) throws Exception{
           http.formLogin().loginPage("/login");
           http.authorizeRequests().antMatchers("/add**/**","/delete**/**","/PatientForm").hasRole("ADMIN");
             http.authorizeRequests().antMatchers("/index**/**").hasRole("USER");
              http.authorizeRequests().antMatchers("/login").permitAll();
          // http.authorizeRequests().anyRequest().authenticated();
           http.exceptionHandling().accessDeniedPage("/notAuthorized");
    }
    
    @Bean
    public PasswordEncoder bcrypt(){
        return new BCryptPasswordEncoder();
    }
    
}
