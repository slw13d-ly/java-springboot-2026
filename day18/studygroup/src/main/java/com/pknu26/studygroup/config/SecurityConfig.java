package com.pknu26.studygroup.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pknu26.studygroup.security.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/api/**") // API 요청은 보안 보호를 무시. 260428 보안 추가
            )
            .authorizeHttpRequests(auth -> auth
                .requestMatchers( // URL 별 접근 권한 설정
                    "/",  // http://localhost:8080/
                    "/user/join",
                    "/user/login",
                    "/css/**",
                    "/images/**",
                    "/js/**",
                    "/trumbowyg/**",
                    "/upload/**"
                ).permitAll()   // 로그인 없이 접속할 수 있는 권한 부여
                
                .requestMatchers("/admin/**").hasRole("ADMIN")  // ROLE_ADMIN 에게만 /admin/ 접속권한
                
                .requestMatchers(
                    "/studypost/create",
                    "/studypost/edit/**",
                    "/studypost/delete/**",
                    "/comment/**",
                    "/application/**",
                    "/board/create",
                    "/board/edit/**",
                    "/board/delete/**"
                ).authenticated()    // 위의 URL은 로그인한 사용자에게만 접속 권한
                .anyRequest().permitAll()            
            )
            .formLogin(form -> form
                .loginPage("/user/login")
                .loginProcessingUrl("/user/login")
                .usernameParameter("loginId")
                .passwordParameter("password")
                .defaultSuccessUrl("/studypost/list", true)  // 접속 성공 후 이동하는 첫페이지
                .failureUrl("/user/login?error=true")  // 로그인 에러났을 때 화면
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true) // 세션 무효화
                .deleteCookies("JSESSIONID") // 로그인 에러났을 때 화면
            )
            .addFilterBefore( // 필터 배치. ID/Password 확인 필터 전 우리가 만든 JWT 필터 먼저 실행
                jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            ;

        return http.build();
    }
    
    /* 260428 JWT관련 신규추가
     * 인증관리자 설정: 로그인시 아이디/패스워드 검증하는 핵심객체
     * @param authenticationConfiguration
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(
                    AuthenticationConfiguration authenticationConfiguration
                ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}