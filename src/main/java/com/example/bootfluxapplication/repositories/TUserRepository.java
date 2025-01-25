package com.example.bootfluxapplication.repositories;

import com.example.bootfluxapplication.entity.TUser;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * @author 23133
 * @description: 第一个参数为实体类参数，第二个为主键类型
 * @param: null
 * @return:
 * @date: 2025/1/24 10:55
 */
@Repository
public interface TUserRepository extends R2dbcRepository<TUser, Long> {

    //只限于单表的复杂条件查询操作
    //直接利用其命名规则就可以完成指定的SQL查询
    public Flux<TUser> findTuserByIdInAndUsernameLike(Collection<Long> id, String username);

}
