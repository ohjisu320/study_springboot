package me.ohjisu.springbootdeveloper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // CSRF 보호 기능 비활성화
                .csrf(csrf -> csrf.disable())

                // "모든 요청(anyRequest)을 허용(permitAll)한다"는 가장 단순한 규칙
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )

                // API 서버이므로 폼 로그인, HTTP Basic 인증 비활성화
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable())

                .build();
    }
}