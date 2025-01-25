package com.example.bootfluxapplication.service;

import com.example.bootfluxapplication.entity.Author;
import com.example.bootfluxapplication.vo.AuthorBookVo;
import reactor.core.publisher.Flux;

public interface AuthorService {
    Flux<Author> list();

    Flux<AuthorBookVo> findAuthBookById(Long id);
}
