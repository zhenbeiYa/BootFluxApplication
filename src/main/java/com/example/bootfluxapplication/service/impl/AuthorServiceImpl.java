package com.example.bootfluxapplication.service.impl;

import com.example.bootfluxapplication.entity.Author;
import com.example.bootfluxapplication.entity.TBook;
import com.example.bootfluxapplication.repositories.AuthRepository;
import com.example.bootfluxapplication.service.AuthorService;
import com.example.bootfluxapplication.vo.AuthorBookVo;
import com.example.bootfluxapplication.vo.BookAuthorVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private DatabaseClient databaseClient;

    @Override
    public Flux<Author> list() {
        return authRepository.findAll();
    }

    @Override
    public Flux<BookAuthorVo> findAuthBookById(Long id) {
        return authRepository.findAuthBookById(id);
    }

    @Override
    public Flux<AuthorBookVo> findAuthBooks() {
        Flux.just(1).buffer();
        return databaseClient.sql("select ta.id as aid,ta.name,tb.* from t_author ta LEFT JOIN t_book tb on ta.id=tb.author_id ORDER BY author_id").fetch().all().bufferUntilChanged(stringObjectMap -> Long.parseLong(stringObjectMap.get("aid").toString())).map(list -> {
            AuthorBookVo authorBookVo = new AuthorBookVo();
            Map<String, Object> stringObjectMap = list.get(0);
            authorBookVo.setId(Long.parseLong(stringObjectMap.get("aid").toString()));
            authorBookVo.setName(stringObjectMap.get("name").toString());
            List<TBook> books = list.stream().map(ele -> {
                TBook tBook = new TBook();
                tBook.setId(Long.parseLong(ele.get("id").toString()));
                tBook.setAuthorId(Long.parseLong(ele.get("author_id").toString()));
                tBook.setTitle(ele.get("title").toString());
                Instant publish_time = LocalDateTime.parse(ele.get("publish_time").toString()).atZone(ZoneId.of("GMT+8")).toInstant();
                tBook.setPublishTime(publish_time);
                return tBook;
            }).collect(Collectors.toList());
            authorBookVo.setBooks(books);
            return authorBookVo;
        });
    }
}
