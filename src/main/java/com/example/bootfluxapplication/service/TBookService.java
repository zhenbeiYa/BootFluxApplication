package com.example.bootfluxapplication.service;

import com.example.bootfluxapplication.entity.TBook;
import reactor.core.publisher.Flux;

public interface TBookService {
    Flux<TBook> list();

    Flux<TBook> findBooksAndAuthor(long parseLong);
}
