package com.example.bootfluxapplication.componant;

import com.example.bootfluxapplication.entity.TUser;
import com.example.bootfluxapplication.repositories.TUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @author 23133
 * @version 1.0
 * @description: 当前用户 ReactiveUserDetailsService 实现类
 * @date 2025/1/31 10:53
 */
@Component
public class CurrUserDetailServiceImpl implements ReactiveUserDetailsService {

    @Autowired
    private DatabaseClient databaseClient;


    //权限分离方式，通过过滤器去实现当前的去权限指称
    @Override
    public Mono<UserDetails> findByUsername(String username) {
        ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        Flux<UserDetails> userFluxList = databaseClient.sql("SELECT u.*,r.id rid,r.name,r.value,rp.perm_id,tp.`value` as `tvalue`,tp.description from t_user u LEFT JOIN t_user_role ur ON ur.user_id = u.id LEFT JOIN t_roles r ON r.id = ur.role_id LEFT JOIN t_role_perm rp ON rp.role_id = r.id LEFT JOIN t_perm tp on tp.id =rp.perm_id WHERE u.username=?").bind(0, username).fetch().all().bufferUntilChanged(stringObjectMap -> Long.parseLong(stringObjectMap.get("rid").toString()))
                .map(list -> {
                    Map<String, Object> stringObjectMap = list.get(0);
                    String password = stringObjectMap.get("password").toString();
                    //Spring家采用了前缀匹配法，依赖于前缀的匹配
                    //比如 Noop前缀 password("{noop}"+password)
                    simpleGrantedAuthorities.add(new SimpleGrantedAuthority(stringObjectMap.get("tvalue").toString()));
                    return User.builder()
                            .username(username).
                            password("{bcrypt}" + password)
                            .roles(stringObjectMap.get("name").toString())
                            //只封装了一种权限，此刻所有角色都只能具有一种权限
                            .authorities(simpleGrantedAuthorities)
                            .build();
                });
        return userFluxList.single();
    }
}
