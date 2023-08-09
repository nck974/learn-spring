package dev.nichoko.security.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

enum UserRole {
    EMPLOYEE,
    MANAGER,
    ADMIN,
}

@Configuration
public class SecurityConfig {

    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");


        return jdbcUserDetailsManager;
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
