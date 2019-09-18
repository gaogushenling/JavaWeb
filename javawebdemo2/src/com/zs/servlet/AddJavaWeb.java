package com.zs.servlet;

import com.zs.entity.Order;
import com.zs.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AddJavaWeb extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String OrderId = request.getParameter("OrderId");
        String Status = request.getParameter("Status");
        String MemberId = request.getParameter("MemberId");
//        String name =new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");


        /*1、查询数据库*/
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
                HelloJavaWeb2.class.getClassLoader().getResourceAsStream("mybatis.xml")
        );
        SqlSession session = factory.openSession(true);/*true 设置自动提交！！！！！！！！！*/
        //生成接口代理
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);

//        List<Order> orderList = orderMapper.listOrder();

        Order order = new Order();
        //随机生成订单号！！！！！！！

        order.setOrderId(OrderId);
        order.setStatus(Integer.valueOf(Status));
        order.setMemberId(Integer.valueOf(MemberId));
        System.out.println(orderMapper.addOrder(order));

        response.sendRedirect("/hello2");

    }


    // 处理 POST 方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
