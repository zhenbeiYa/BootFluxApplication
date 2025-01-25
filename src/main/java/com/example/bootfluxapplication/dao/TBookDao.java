package com.example.bootfluxapplication.dao;

import com.example.bootfluxapplication.entity.TBook;
import com.example.bootfluxapplication.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @author 23133
 * @version 1.0
 * @description:
 * @date 2025/1/24 19:59
 */
@Repository
public class TBookDao {

    @Autowired
    private BookRepository bookRepository;

    public Flux<TBook> list() {
        return  bookRepository.findAll();
    }

    public Flux<TBook> findBooksAndAuthor(long parseLong) {
        return  bookRepository.findBooksAndAuthor(parseLong);
    }
}
