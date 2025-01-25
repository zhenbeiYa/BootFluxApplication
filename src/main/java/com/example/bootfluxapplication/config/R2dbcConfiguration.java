package com.example.bootfluxapplication.config;

import com.example.bootfluxapplication.converter.TBookConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.data.r2dbc.dialect.MySqlDialect;
import org.springframework.data.r2dbc.dialect.R2dbcDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 23133
 * @version 1.0
 * @description: r2dbc配置
 * @date 2025/1/24 10:51
 */
@Configuration
//开启r2dbc仓库功能
@EnableR2dbcRepositories
public class R2dbcConfiguration {



    @Bean
    @ConditionalOnMissingBean
    public R2dbcCustomConversions conversions() {
        R2dbcDialect dialect;
        return  R2dbcCustomConversions.of(MySqlDialect.INSTANCE,new TBookConverter());
    }
}
