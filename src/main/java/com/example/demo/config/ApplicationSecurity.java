package com.example.demo.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


@ComponentScan("com.example.demo.config")
@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new BCryptPasswordEncoder())
                .usersByUsernameQuery("select name, password, enabled from user where name=? ")
                .authoritiesByUsernameQuery("select name, role from user where name=?")
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .authorizeRequests()
                .antMatchers("/addnewuser","/delete/").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();


    }
    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/signup","layout","registration-form","/resources/css/*")
//                .permitAll()
//                .anyRequest()
//
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .clearAuthentication(true)
//                .invalidateHttpSession(true)
//                .logoutSuccessUrl("/login");
//    }
}
