package com.example.bootfluxapplication.service.impl;

import com.example.bootfluxapplication.entity.Author;
import com.example.bootfluxapplication.repositories.AuthRepository;
import com.example.bootfluxapplication.service.AuthorService;
import com.example.bootfluxapplication.vo.AuthorBookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author 23133
 * @version 1.0
 * @description:
 * @date 2025/1/24 19:08
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthRepository authRepository;
    @Override
    public Flux<Author> list() {
        return authRepository.findAll();
    }

    @Override
    public Flux<AuthorBookVo> findAuthBookById(Long id) {
         return  authRepository.findAuthBookById(id);
    }
}
