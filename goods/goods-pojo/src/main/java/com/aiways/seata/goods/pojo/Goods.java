package com.aiways.seata.goods.pojo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

/**
 * @author wujing
 * @date 2020/4/24 22:44
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Goods {


    Integer id;
    String name;
    Long fee;
    Integer stock;
}
