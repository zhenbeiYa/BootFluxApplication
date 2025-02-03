package com.example.bootfluxapplication.entity;

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
 * @description:
 * @date 2025/1/27 18:44
 */
@Table(name = "t_role_perm")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TRolePerm  implements Serializable {
    @Id
    private Long id;

    private  Long roleId;

    private  Long permId;

    private Instant createTime;

    private Instant updateTime;

}
