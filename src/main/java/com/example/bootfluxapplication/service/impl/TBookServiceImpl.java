package com.example.bootfluxapplication.service.impl;

import com.example.bootfluxapplication.dao.TBookDao;
import com.example.bootfluxapplication.entity.TBook;
import com.example.bootfluxapplication.service.TBookService;
import com.example.bootfluxapplication.vo.BookAuthorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * @author 23133
 * @version 1.0
 * @description:
 * @date 2025/1/24 19:59
 */
@Service
public class TBookServiceImpl  implements TBookService {

    @Autowired
    private TBookDao tBookDao;


    @Override
    public Flux<TBook> list() {
        return tBookDao.list();
    }

    @Override
    public Flux<BookAuthorVo> findBooksAndAuthor(long parseLong) {
        return tBookDao.findBooksAndAuthor(parseLong);
    }


}
