package com.example.bootfluxapplication.contoller;

import com.example.bootfluxapplication.entity.TBook;
import com.example.bootfluxapplication.service.TBookService;
import com.example.bootfluxapplication.vo.BookAuthorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

/**
 * @author 23133
 * @version 1.0
 * @description:书籍实体类
 * @date 2025/1/24 19:58
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private TBookService tBookService;

    @GetMapping("/list")
    public Flux<TBook> list(){
        return  tBookService.list();
    }

    @PostMapping("/info")
    public Flux<BookAuthorVo> findBooksByAuthorId(@RequestParam("id")Integer id){
        return  tBookService.findBooksAndAuthor(Long.parseLong(String.valueOf(id)));
    }
}
