package com.example.bootfluxapplication.repositories;

import com.example.bootfluxapplication.entity.Author;
import com.example.bootfluxapplication.vo.AuthorBookVo;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AuthRepository extends R2dbcRepository<Author, Long> {

    @Query("select au.id,au.name,bk.author_id,bk.title,bk.publish_time from t_author au left join t_book bk on au.id=bk.author_id where title!=\"\" and au.id=?")
    Flux<AuthorBookVo> findAuthBookById(Long id);
}
