package com.example.learn_srpring_security.basic;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class BasicAuthSecurityConfiguration {

        @Bean
        SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests(
                    auth -> {
                        auth
                                .anyRequest().authenticated();
                    });
            http.sessionManagement(
                    session ->
                            session.sessionCreationPolicy(
                                    SessionCreationPolicy.STATELESS)
            );
            //http.formLogin(withDefaults());
            http.httpBasic(withDefaults());
            http.csrf(csrf -> csrf.disable());


            return http.build();

        }
        @Bean
        public UserDetailsService userDetailsService() {

           var user =  User.withUsername("in28minutes")
                    .password("{noop}dummy")
                    .roles("USER")
                    .build();

           var admin = User.withUsername("admin")
                   .password("{noop}dummy")
                   .roles("ADMIN")
                   .build();

            return new InMemoryUserDetailsManager();

        }

}
