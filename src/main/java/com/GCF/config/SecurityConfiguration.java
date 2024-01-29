package com.GCF.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration 
{
	private final JwtAuthFilter jwtAuthFilter;
	private final AuthenticationProvider authenticationProvider;
	@Bean
	
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request.requestMatchers("/categories/**","/login/**","/evaluer/**","/planification/**","/postuler/**","/rejoindre/**","/evaluation/**", "/accueil/**").permitAll()
                        .requestMatchers("/assistant/**").hasAnyAuthority("ADMIN")
                        .requestMatchers("/entreprise/**").hasAnyAuthority("ASSISTANT","ADMIN")
                        .requestMatchers("/individu/**").hasAnyAuthority("ASSISTANT", "ADMIN")
                        .requestMatchers("/formateur/**").hasAnyAuthority("ASSISTANT", "ADMIN")
                        .requestMatchers("/formateurExterne/**").hasAnyAuthority("ASSISTANT", "ADMIN")
                        .requestMatchers("/formation/**").hasAnyAuthority("ASSISTANT", "ADMIN")
                        .requestMatchers("/date/**").hasAnyAuthority("ASSISTANT", "ADMIN","FORMATEUR")
                        .requestMatchers("/planification/**").hasAnyAuthority("ASSISTANT", "ADMIN","FORMATEUR")
                        .requestMatchers("/mesFormation/**").hasAnyAuthority("FORMATEUR")
                        .anyRequest().authenticated())
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider).addFilterBefore(
                		jwtAuthFilter, UsernamePasswordAuthenticationFilter.class
                );
        return httpSecurity.build();
    }
}
