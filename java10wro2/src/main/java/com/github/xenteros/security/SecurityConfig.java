package com.github.xenteros.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/api**").authenticated()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/login.html").permitAll()
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/users/login")
                .failureHandler(
                        (req, resp, e) -> resp.sendError(HttpStatus.BAD_REQUEST.value(), "Username or password invalid"))
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/api/users/me")
                .permitAll();

        http.logout()
                .logoutUrl("/users/logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl("/login.html")
                .permitAll();

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER")
//                .and()
//                .withUser("admin").password("secret").roles("ADMIN");
//    }


    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
}
