package com.example.bootfluxapplication.service;

import com.example.bootfluxapplication.entity.TUser;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<TUser> list();

    Mono<TUser> getOne(String username);

    Mono<TUser> getDataOne(String username);
}
