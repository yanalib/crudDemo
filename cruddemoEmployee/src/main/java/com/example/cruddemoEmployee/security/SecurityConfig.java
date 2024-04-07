package com.example.cruddemoEmployee.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    //support for JDBC, no more hardcoded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource); //tells Spring to use JDBC authentication
    }

    //In-memory authentication
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}test123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}test123")
//                .roles("EMPLOYEE", "MANAGER")
//                .build();
//
//        UserDetails sonya = User.builder()
//                .username("sonya")
//                .password("{noop}testt123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john, mary, sonya);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer -> configurer
                        .requestMatchers(HttpMethod.GET, "/api/members").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/members/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/members").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/members/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/members/**").hasRole("ADMIN")
        );
        //Use Basic Auth
        http.httpBasic(Customizer.withDefaults());

        //disable CSRF
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
