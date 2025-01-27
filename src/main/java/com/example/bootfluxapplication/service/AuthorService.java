package com.example.bootfluxapplication.service;

import com.example.bootfluxapplication.entity.Author;
import com.example.bootfluxapplication.vo.AuthorBookVo;
import com.example.bootfluxapplication.vo.BookAuthorVo;
import reactor.core.publisher.Flux;

public interface AuthorService {
    Flux<Author> list();

    Flux<BookAuthorVo> findAuthBookById(Long id);

    Flux<AuthorBookVo> findAuthBooks();

}
