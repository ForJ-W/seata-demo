package com.aiways.seata;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author wujing
 * @date 2020/4/25 1:15
 */
@SpringBootApplication
@MapperScan("com.aiways.seata.order.mapper")
@EnableDiscoveryClient
@EnableFeignClients
@EnableApolloConfig
public class OrderApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrderApplication.class);
    }
}
