package com.aiways.seata.order.service.impl;


import io.seata.spring.boot.autoconfigure.properties.registry.ConfigApolloProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wujing
 * @date 2020/5/5 15:51
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class OrderServiceImplTest {



    @Autowired
    private ConfigApolloProperties configApolloProperties;

    @Test
    public void apolloConfigTest() {
        ConfigApolloProperties configApolloProperties = this.configApolloProperties;
        log.info(configApolloProperties.toString());
    }

}