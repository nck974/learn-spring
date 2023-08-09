package dev.nichoko.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

enum UserRole {
    EMPLOYEE,
    MANAGER,
    ADMIN,
}

@Configuration
public class SecurityConfig {

    @Bean
    InMemoryUserDetailsManager userDetailsManager() {
        final UserDetails userRoleEmployee = User.builder()
                .username("test1")
                .password("{noop}test1")
                .roles(UserRole.EMPLOYEE.toString())
                .build();
        final UserDetails userRoleManager = User.builder()
                .username("test2")
                .password("{noop}test2")
                .roles(UserRole.EMPLOYEE.toString(), UserRole.MANAGER.toString())
                .build();
        final UserDetails userRoleAdmin = User.builder()
                .username("test3")
                .password("{noop}test3")
                .roles(UserRole.EMPLOYEE.toString(), UserRole.MANAGER.toString(), UserRole.ADMIN.toString())
                .build();
        return new InMemoryUserDetailsManager(userRoleEmployee, userRoleManager, userRoleAdmin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure -> {
            final String employees_path = "/api/v1/employees";
            final String employee_path = "/api/v1/employees/**";
            configure
                    .requestMatchers(HttpMethod.GET, employee_path)
                    .hasRole(UserRole.EMPLOYEE.toString())
                    .requestMatchers(HttpMethod.GET, employees_path)
                    .hasRole(UserRole.EMPLOYEE.toString())
                    .requestMatchers(HttpMethod.POST, employees_path)
                    .hasRole(UserRole.MANAGER.toString())
                    .requestMatchers(HttpMethod.PUT, employees_path)
                    .hasRole(UserRole.MANAGER.toString())
                    .requestMatchers(HttpMethod.DELETE, employees_path)
                    .hasRole(UserRole.ADMIN.toString());
        });

        // Use basic authentication
        http.httpBasic(Customizer.withDefaults());

        // Disable CSRF
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
