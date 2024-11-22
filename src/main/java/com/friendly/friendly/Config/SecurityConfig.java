// package com.friendly.friendly.Config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public BCryptPasswordEncoder bCryptPasswordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers(
//                     "/v3/api-docs/**",    // API docs
//                     "/swagger-ui/**",     // Swagger UI resources
//                     "/swagger-ui.html",   // Swagger UI HTML
//                     "/webjars/**",        // Webjars (JS/CSS)
//                     "/swagger-resources/**"
//                 ).permitAll()
//                 .anyRequest().authenticated()
//             )
//             .csrf(csrf -> csrf.disable());
//         return http.build();
//     }
// }
