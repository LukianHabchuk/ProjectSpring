package com.pl.Project.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//public class Security extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserAuthenticationDetails userAthenticationDetails;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userAthenticationDetails);
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authenticationProvider =
//                new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userAthenticationDetails);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.httpBasic().disable()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/registration").permitAll()
//                .antMatchers("/about").permitAll()
//                .antMatchers("/contact").permitAll()
//                .antMatchers("/faqs").permitAll()
//                .antMatchers("/store").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .usernameParameter("email")
//                .passwordParameter("passwd")
//                .defaultSuccessUrl("/main", true)
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login")
//                .invalidateHttpSession(true);
//    }
//
//}
