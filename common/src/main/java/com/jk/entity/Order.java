package com.jk.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private Integer goodsId;  // 商品id

    private String orderNum;

    private String orderName; // 订单名称/商品名称

    private BigDecimal orderPrice;  // 订单价格/ 购买时的商品价格

    private Integer orderCount;
}
