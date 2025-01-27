package com.example.bootfluxapplication.converter;

import com.example.bootfluxapplication.entity.Author;
import com.example.bootfluxapplication.vo.BookAuthorVo;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.time.Instant;


/**
 * @author 23133
 * @version 1.0
 * @description: 自定义数据封装响应器
 * @date 2025/1/24 20:20
 */
@ReadingConverter
public class TBookConverter implements Converter<Row, BookAuthorVo> {

    @Override
    public BookAuthorVo convert(Row source) {
        BookAuthorVo bookAuthorVo = new BookAuthorVo();
        bookAuthorVo.setId(source.get("id", Long.class));
        bookAuthorVo.setTitle(source.get("title", String.class));
        bookAuthorVo.setPublishTime(source.get("publish_time", Instant.class));
        Long authorId = source.get("author_id", Long.class);
        bookAuthorVo.setAuthorId(authorId);
        if (source.getMetadata().contains("name")) {
            Author author = new Author();
            author.setId(authorId);
            author.setName(source.get("name", String.class));
            bookAuthorVo.setAuthor(author);
        }
        return bookAuthorVo;
    }
}
