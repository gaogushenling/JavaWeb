package com.zs.entity;

import lombok.Data;
import java.util.Date;
@Data
public class Order {
    private String orderId;
    private Integer status;
    private Integer memberId;
    private Date createTime;
    private Date updateTime;
}
