package com.example.bootfluxapplication.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 23133
 * @version 1.0
 * @description: 作者书籍Vo
 * @date 2025/1/24 19:27
 */
public class AuthorBookVo implements Serializable {

    //作者ID
    private Long id;
    //作者名称
    private String name;
    //作者所作书籍名称
    private String title;

    private Long authorId;
    //书籍发布时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:ss:mm")
    private LocalDateTime publishTime;

    public AuthorBookVo() {
    }

    public AuthorBookVo(Long id, String name, String title, Long authorId, LocalDateTime publishTime) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.authorId = authorId;
        this.publishTime = publishTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }
}
