package com.example.bootfluxapplication.contoller;

import com.example.bootfluxapplication.entity.Author;
import com.example.bootfluxapplication.service.AuthorService;
import com.example.bootfluxapplication.vo.AuthorBookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

/**
 * @author 23133
 * @version 1.0
 * @description: 作者业务层
 * @date 2025/1/24 19:07
 */
@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/list")
    public Flux<Author> list(){
        return  authorService.list();
    }

    @PostMapping("/book")
    public Flux<AuthorBookVo> findAuthBookById(@RequestParam("id")Integer id){
        return  authorService.findAuthBookById(Long.parseLong(String.valueOf(id)));
    }
}
