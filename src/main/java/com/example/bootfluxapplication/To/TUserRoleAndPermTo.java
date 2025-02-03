package com.example.bootfluxapplication.To;

import com.example.bootfluxapplication.entity.TPerm;
import com.example.bootfluxapplication.entity.TRoles;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 23133
 * @version 1.0
 * @description: 用户权限To
 * @date 2025/2/1 9:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TUserRoleAndPermTo  implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String email;

    private Integer phone;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    @Transient
    //角色
    private  List<TRoles> roles;

    //权限表
    @Transient
    private List<TPerm> perms;
}
