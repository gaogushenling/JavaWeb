package com.zs.mapper;

import com.zs.entity.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> listOrder();

    int updateOrderByMemberId(Order order);

    List<Order> listOrderID(String orderId);

    int addOrder(Order order);

    int deleteOrder(String orderId);

    int deleteOrdermemberId(Integer memberId);
}
