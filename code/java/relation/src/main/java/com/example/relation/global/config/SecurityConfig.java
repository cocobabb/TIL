package com.example.relation.global.config;

import com.example.relation.global.security.SecurityPathConfig;
import com.example.relation.global.security.handler.CustomAccessDeniedHandler;
import com.example.relation.global.security.handler.JwtAuthenticationEntryPoint;

import com.example.relation.global.security.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


    @Bean
    public PasswordEncoder passwordEncoder() {
//        메서드 리턴 타입이 BCryptPasswordEncoder 인데 메서드 타입은 PasswordEncoder
//        => 다형성임을 알 수 있음
//        => 비밀번호 보안 방법은 여러개가 존재함
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        사이트 간 요청 위조
//                - CSRF 공격은 쿠키를 통해 이루어지는데, REST API는 헤더를 활용해 인증을 하므로 CSRF 공격 방지를 할 필요가 없다
//                - 단,  REST API도 쿠키를 통해 인증을 할 수 있는데, 이때는 추가적인 조치가 필요
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
//                        에러 발생 시 redircet되는 url: /error
//                        - `GlobalExceptionHandler`에서 `Exception`에 대한 처리를 하면 필요 없다.
//                        - 개발할때는 우선 전체 `Exception`에 대한 처리를 하지 않고, `/error` 를 열어두는걸 추천
//                        "/images/**" 경로 인증 허용하지 않으면 이미지 볼수 없음
                        .requestMatchers("/auth/**","/error", "/images/**").permitAll()
                        .requestMatchers(HttpMethod.GET, SecurityPathConfig.PUBLIC_GET_URLS).permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exception -> exception
                        .accessDeniedHandler(accessDeniedHandler)
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder
    ) {

        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        //        user detail -> db에서 user를 가져올 수 있는 객체
        authProvider.setUserDetailsService(userDetailsService);
        //        passwordEncoder -> pw를 인코딩할 수 있는 객체
        authProvider.setPasswordEncoder(passwordEncoder);

//        를 활용해서 "AuthenticationManager"에 대한 구현체(인증관리 하는 구현체)를 만들어준다.
        return new ProviderManager(authProvider);
    }

}
