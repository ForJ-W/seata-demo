package com.aiways.seata.order.pojo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author wujing
 * @date 2020/4/30 14:32
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cart {

    Integer goodsId;
    Integer goodsNum;
}
