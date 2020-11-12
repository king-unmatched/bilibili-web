package com.jk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Order {
    private Integer goodsId;  // 商品id

    private String orderNum;

    private String orderName; // 订单名称/商品名称

    private BigDecimal orderPrice;  // 订单价格/ 购买时的商品价格

    private Integer orderCount;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date orderCreatetime;
}
