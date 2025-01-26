package com.example.bootfluxapplication.service;

import com.example.bootfluxapplication.entity.TBook;
import com.example.bootfluxapplication.vo.AuthorBookVo;
import reactor.core.publisher.Flux;

public interface TBookService {
    Flux<TBook> list();

    Flux<AuthorBookVo> findBooksAndAuthor(long parseLong);
}
