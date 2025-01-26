package com.example.bootfluxapplication.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

/**
 * @author 23133
 * @version 1.0
 * @description: 作者实体类
 * @date 2025/1/24 19:06
 */
@Table(value = "t_author")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author implements Serializable {
    private Long id;
    private String name;
}
