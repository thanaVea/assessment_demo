package com.kbtg.bootcamp.posttest.security;

import com.kbtg.bootcamp.posttest.dao.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private RolesRepository rolesRepository;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
       return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((requests) ->
                        requests
                                .requestMatchers("/admin").hasRole("ADMIN")
                                .anyRequest().permitAll())
               .httpBasic(withDefaults())
               .build();
    }

// ---------------------- กรณีอยากเรียกแบบ call check rolesRepository ครับ  ----------------------
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//            RolesEntity role = rolesRepository.findByName(username);
//
//            if (role != null) {
//                return org.springframework.security.core.userdetails.User
//                        .withUsername(role.getName())
//                        .password(encoder.encode(role.getPassword()))
//                        .authorities(role.getAuthorities())
//                        .build();
//            } else {
//                throw new UsernameNotFoundException("User not found");
//            }
//        };
//    }

}
