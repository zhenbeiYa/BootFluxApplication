package com.example.bootfluxapplication.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author 23133
 * @version 1.0
 * @description: controller
 * @date 2025/1/17 10:56
 */
@RestController
@RequestMapping("/rest")
public class MyRestController {
    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("hello");
    }
}
