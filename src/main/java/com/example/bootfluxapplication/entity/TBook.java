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
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TBook implements Serializable {
    @Id
    private Long id;

    private String title;

    private Long authorId;


    private Instant publishTime;
}
