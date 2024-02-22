package com.developers.Schedule.SecurityConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/devs/api/v1/").permitAll();
                    auth.requestMatchers("/devs/api/v1/{id}").permitAll();
                    auth.requestMatchers("/devs/api/v1/name/{name}").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin(formLogin -> formLogin
                        .successHandler(successHandler())
                        .permitAll()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                        .invalidSessionUrl("/devs/api/v1/")
                        .maximumSessions(1)
                        .expiredUrl("/devs/api/v1/")
                        .sessionRegistry(sessionRegistry())
                );
        return httpSecurity.build();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    public AuthenticationSuccessHandler successHandler() {
        return ((request, response, authentication) -> {
            response.sendRedirect("Endpoint para redireccion exitosa");
        });
    }
}
