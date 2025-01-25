package com.example.bootfluxapplication.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author 23133
 * @version 1.0
 * @description:书籍实体类
 * @date 2025/1/24 19:55
 */
@Table(value = "t_book")
public class TBook implements Serializable {
    @Id
    private Long id;

    private String title;

    private Long authorId;


    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:ss:mm")
    private Instant publishTime;


    private Author author;

    public TBook() {

    }

    public TBook(Long id, String title, Long authorId, Instant publishTime) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.publishTime = publishTime;
    }

    public TBook(Long id, String title, Long authorId, Instant publishTime, Author author) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.publishTime = publishTime;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Instant getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Instant publishTime) {
        this.publishTime = publishTime;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
