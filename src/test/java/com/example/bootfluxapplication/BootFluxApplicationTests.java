package com.example.bootfluxapplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

@SpringBootTest
class BootFluxApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void HttpServerTest() {
        HttpHandler httpHandler = (request, response) -> {
            /*if(request.getURI().equals("/hello")) {
            }*/
//            System.out.println("request = " + request.getURI().getPath());
            if (request.getURI().getPath().equals("/hello")) {
                DataBufferFactory dataBufferFactory = response.bufferFactory();
                //设定容量
                DataBuffer wrap = dataBufferFactory.wrap(new String(request.getURI().getPath() + "hello~!").getBytes());
                return response.writeWith(Mono.just(wrap));
            }
            return response.setComplete();
        };
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        //bindNow():立即绑定
        HttpServer.create().host("localhost").port(8888).handle(adapter).bindNow();

        try {
            //堵住线程进行
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
