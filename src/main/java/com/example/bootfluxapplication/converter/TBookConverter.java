package com.example.bootfluxapplication.converter;

import com.example.bootfluxapplication.entity.Author;
import com.example.bootfluxapplication.entity.TBook;
import com.example.bootfluxapplication.vo.AuthorBookVo;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.Instant;


/**
 * @author 23133
 * @version 1.0
 * @description: 自定义数据封装响应器
 * @date 2025/1/24 20:20
 */
@ReadingConverter
public class TBookConverter implements Converter<Row, AuthorBookVo> {

    @Override
    public AuthorBookVo convert(Row source) {
        AuthorBookVo authorBookVo = new AuthorBookVo();
        authorBookVo.setId(source.get("id", Long.class));
        authorBookVo.setTitle(source.get("title", String.class));
        authorBookVo.setPublishTime(source.get("publish_time", Instant.class));
        Long authorId = source.get("author_id", Long.class);
        authorBookVo.setAuthorId(authorId);
        if (StringUtils.hasLength(source.get("name", String.class))) {
            Author author = new Author();
            author.setId(authorId);
            author.setName(source.get("name", String.class));
            authorBookVo.setAuthor(author);
        }
        return authorBookVo;
    }
}
