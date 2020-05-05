package com.aiways.seata;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author wujing
 * @date 2020/4/24 21:35
 */
@SpringBootApplication
@MapperScan("com.aiways.seata.goods.mapper")
@EnableDiscoveryClient
@EnableApolloConfig
public class GoodsApplication {

    public static void main(String[] args) {

        SpringApplication.run(GoodsApplication.class);
    }
}
