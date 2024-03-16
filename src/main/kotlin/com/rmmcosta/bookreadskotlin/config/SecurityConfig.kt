package com.rmmcosta.bookreadskotlin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.web.SecurityFilterChain
import java.beans.Customizer


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/", "/images/**", "/scripts/**", "/styles/**").permitAll()
                    .anyRequest().authenticated()
            }
            .formLogin(withDefaults())
            .oauth2Login(withDefaults())
            .build()
    }

}