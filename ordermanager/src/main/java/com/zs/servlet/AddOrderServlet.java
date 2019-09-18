package com.zs.servlet;

import com.zs.entity.Order;
import com.zs.mapper.OrderMapper;
import com.zs.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class AddOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何获得表单数据
        //获得请求参数用getParameter("参数名\表单名")
        Integer status = Integer.parseInt(req.getParameter("status"));
        Integer memberId = Integer.parseInt(req.getParameter("memberId"));

        Order order = new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setStatus(status);
        order.setMemberId(memberId);
        //将数据插入到数据库
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        orderMapper.addOrder(order);
        sqlSession.close();

        //跳转回列表页  重定向
        resp.sendRedirect("/Orderlist");
    }
}
