package com.example.bootfluxapplication.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author 23133
 * @version 1.0
 * @description:
 * @date 2025/1/24 10:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TUser implements Serializable {

    private Long id;

    private String username;

    private String password;

    private String email;

    private Integer phone;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:ss:mm")
    private LocalDateTime createTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:ss:mm")
    private LocalDateTime updateTime;

}
