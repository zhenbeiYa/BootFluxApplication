package com.example.bootfluxapplication.dao;

import com.example.bootfluxapplication.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author 23133
 * @version 1.0
 * @description:
 * @date 2025/1/24 10:16
 */
@Repository
@Component
public class UserDao {

    @Autowired
    R2dbcEntityTemplate r2dbcEntityTemplate;

    @Autowired
    DatabaseClient databaseClient;

    public Flux<TUser> list() {
        return r2dbcEntityTemplate.select(TUser.class).all();
    }

    public Mono<TUser> getOne(String username) {
        ;
        return r2dbcEntityTemplate.selectOne(Query.query(Criteria.empty().and("username").is(username)), TUser.class);
    }

    public Mono<TUser> getDataOne(String username) {
        return databaseClient.sql("select * from t_user where username=?name").bind("name", username).fetch().one().map(ele -> {
            String name = String.valueOf(ele.get("username"));
            String password = String.valueOf(ele.get("password"));
            String email = String.valueOf(ele.get("email"));
            int phone = Integer.parseInt(String.valueOf(ele.get("phone")));
            TUser tUser = new TUser();
            tUser.setUsername(name);
            tUser.setPassword(password);
            tUser.setPhone(phone);
            tUser.setEmail(email);
            tUser.setCreateTime((LocalDateTime) ele.get("create_time"));
            tUser.setUpdateTime((LocalDateTime) ele.get("update_time"));
            return tUser;
        });
    }
}
