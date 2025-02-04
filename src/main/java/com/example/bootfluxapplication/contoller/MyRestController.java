package com.example.bootfluxapplication.contoller;

import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.net.http.HttpRequest;
import java.time.Duration;

/**
 * @author 23133
 * @version 1.0
 * @description: controller
 * @date 2025/1/17 10:56
 */
@RestController
@RequestMapping("/rest")
public class MyRestController {
    @PreAuthorize("hasRole('admin')")
    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("hello");
    }

    @PreAuthorize("hasAuthority('view')")
    @GetMapping("/hello/{key}")
    public Mono<String> helloKey(@PathVariable("key") String Key) {
        return Mono.just("hello" + Key);
    }

    @PreAuthorize("hasAuthority('download')")
    @GetMapping("/hello1")
    public Mono<String> helloKey2(@RequestParam(value = "key", required = false, defaultValue = "Key") String Key) {
        return Mono.just("hello" + Key);
    }


    /**
     * @description: sse测试 需要利用MediaType表明返回类型为事件流
     * @param: key
     * @return: reactor.core.publisher.Flux<java.lang.String>
     * @author 23133
     * @date: 2025/1/18 10:51
     */
    @CrossOrigin
    @GetMapping(value = "/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> seeV() {
        return Flux.range(1, 10).map(ele -> {
            return ServerSentEvent.builder(ele + "heihei").data("kkk").event("ko").comment("explanation").build();
        }).delayElements(Duration.ofMillis(500));

    }
}
