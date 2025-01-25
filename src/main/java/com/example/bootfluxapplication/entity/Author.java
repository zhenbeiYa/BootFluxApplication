package com.example.bootfluxapplication.entity;

import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

/**
 * @author 23133
 * @version 1.0
 * @description: 作者实体类
 * @date 2025/1/24 19:06
 */
@Table(value = "t_author")
public class Author implements Serializable {
    private Long id;
    private String name;

    public Author() {

    }

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
