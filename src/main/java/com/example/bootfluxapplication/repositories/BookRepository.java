package com.example.bootfluxapplication.repositories;

import com.example.bootfluxapplication.entity.TBook;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends R2dbcRepository<TBook, Long> {

}
