package com.example.bootfluxapplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 * @author 23133
 * @version 1.0
 * @description:  r2dbc配置
 * @date 2025/1/24 10:51
 */
@Configuration
//开启r2dbc仓库功能
@EnableR2dbcRepositories
public class R2dbcConfiguration {


}
