package com.example.spring_boot_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // http.authorizeHttpRequests(request->request.anyRequest().permitAll());
        // http.authorizeHttpRequests(request->request.anyRequest().denyAll());
        // http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
        http.authorizeHttpRequests(request->request.requestMatchers("/notices", "/contact", "/error").permitAll()
                .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());

       /* http.formLogin(flc->flc.disable());
        http.httpBasic(hbc->hbc.disable());*/
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
}
