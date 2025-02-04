package com.example.bootfluxapplication.config;


import com.example.bootfluxapplication.componant.CurrUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 23133
 * @version 1.0
 * @description: SpringSecurity 配置
 * @date 2025/1/29 10:34
 */
//开启方法级的权限和角色认证
@EnableReactiveMethodSecurity(useAuthorizationManager=true)
@Configuration
public class SecurityConfiguration {
    @Autowired
    private CurrUserDetailServiceImpl currUserDetailService;

    @Bean
    SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        //配置静态资源的默认访问
        http.authorizeExchange(exchange -> {
            //静态资源允许访问
            exchange.matchers(PathRequest.toStaticResources().atCommonLocations()).permitAll();
//            exchange.pathMatchers("/rest/**");
            exchange.anyExchange().authenticated();
        });
        //配置表单登录,自定义登录页面
        http.formLogin(formLoginSpec -> {
            //之后可以使用vue3+elementpulus构建表单
        });
        http.csrf(csrfSpec -> {
            csrfSpec.disable();
        });

        http.authenticationManager(new UserDetailsRepositoryReactiveAuthenticationManager(currUserDetailService));
        return http.build();
    }
}
