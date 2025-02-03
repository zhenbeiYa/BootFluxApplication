package com.example.bootfluxapplication.componant;

import com.example.bootfluxapplication.entity.TUser;
import com.example.bootfluxapplication.repositories.TUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.r2dbc.core.DatabaseClient;
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
import java.util.List;
import java.util.Map;

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



    @Override
    public Mono<UserDetails> findByUsername(String username) {
        Flux<UserDetails> userFluxList = databaseClient.sql("SELECT u.*,r.id rid,r.name,r.value,rp.perm_id,tp.`value` as `tvalue`,tp.description from t_user u LEFT JOIN t_user_role ur ON ur.user_id = u.id LEFT JOIN t_roles r ON r.id = ur.role_id LEFT JOIN t_role_perm rp ON rp.role_id = r.id LEFT JOIN t_perm tp on tp.id =rp.perm_id WHERE u.username=?").bind(0, username).fetch().all().bufferUntilChanged(stringObjectMap -> Long.parseLong(stringObjectMap.get("rid").toString()))
                .map(list -> {
                    Map<String, Object> stringObjectMap = list.get(0);
                    String password = stringObjectMap.get("password").toString();
                    return User.builder().username(username).password("{noop}"+password)
                            .authorities(stringObjectMap.get("tvalue").toString()).roles(stringObjectMap.get("value").toString()).build();
                });
        return userFluxList.single();
    }
}
