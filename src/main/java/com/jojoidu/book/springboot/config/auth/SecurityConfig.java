package com.jojoidu.book.springboot.config.auth;

import com.jojoidu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정들 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable() // h2-console 화면 사용 위해 해당 옵션들 disable
                .and()
                    .authorizeRequests() // URL별 권한관리를 설정하는 옵션의 시작점
                    //anthMathers : 권한 관리 대상을 지정하는 옵션 permitAll()옵션을 사용해 전체 열람 권한 줌
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated() // 설정된 값들 이외의 설정들
                .and()
                    .logout()
                    .logoutSuccessUrl("/") // 로그아웃 기능에 대한 여러 설정 진입점. 로그아웃 성공시 / 로 이동함
                .and()
                    .oauth2Login()
                    .userInfoEndpoint() // Oauth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들 담당
                    .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속 조치 진행할 UserService 인터페이스의 구현체를 등록함
    }
}
