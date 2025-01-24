package com.example.bootfluxapplication.service.impl;

import com.example.bootfluxapplication.dao.UserDao;
import com.example.bootfluxapplication.entity.TUser;
import com.example.bootfluxapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author 23133
 * @version 1.0
 * @description:
 * @date 2025/1/24 10:16
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public Flux<TUser> list() {
        return userDao.list();
    }

    @Override
    public Mono<TUser> getOne(String username) {
        return userDao.getOne(username);
    }

    @Override
    public Mono<TUser> getDataOne(String username) {

        return userDao.getDataOne(username);
    }
}
