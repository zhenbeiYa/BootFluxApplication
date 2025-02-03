package com.example.bootfluxapplication.contoller;

import com.example.bootfluxapplication.entity.TUser;
import com.example.bootfluxapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author 23133
 * @version 1.0
 * @description:
 * @date 2025/1/24 10:17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Flux<TUser>  list(){
        return  userService.list();
    }

    @GetMapping("/one")
    public Mono<TUser> getOne(@RequestParam("username")String username){
        return  userService.getOne(username);
    }
    //采用dataclient的方式进行数据请求
    @GetMapping("/data/one")
    public Mono<TUser> getDataOne(@RequestParam("username")String username){
        return  userService.getDataOne(username);
    }

}
