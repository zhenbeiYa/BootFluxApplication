package com.example.bootfluxapplication.vo;

import com.example.bootfluxapplication.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author 23133
 * @version 1.0
 * @description: 作者书籍Vo
 * @date 2025/1/24 19:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("t_book")
public class BookAuthorVo implements Serializable {

    //作者ID
    @Id
    private Long id;
    //作者名称
    private String name;
    //作者所作书籍名称
    private String title;

    private Long authorId;
    //书籍发布时间

    private Instant publishTime;

    private Author author;
}
