package com.aiways.seata.order.pojo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author wujing
 * @date 2020/4/24 22:44
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    String id;
    String detail;
    Long totalFee;
}
