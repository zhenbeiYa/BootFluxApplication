package com.example.bootfluxapplication.vo;

import com.example.bootfluxapplication.entity.TBook;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.List;

/**
 * @author 23133
 * @version 1.0
 * @description: 作者图书 Vo
 * @date 2025/1/26 9:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("t_author")
public class AuthorBookVo implements Serializable {
    @Id
    private Long id;
    private String name;
    //非数据库字段，临时字段
    @Transient
    List<TBook> books;
}
