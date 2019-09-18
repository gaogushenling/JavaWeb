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

public class HelloJavaWeb extends HttpServlet {
    /**
     * 必须重写service，只需要在service方法里处理逻辑就可以了
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*1、查询数据库*/
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
                HelloJavaWeb.class.getClassLoader().getResourceAsStream("mybatis.xml")
        );
        SqlSession session = factory.openSession(true);/*true 设置自动提交！！！！！！！！！*/
        //生成接口代理
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);

        List<Order> orderList = orderMapper.listOrder();
        /*2、拼接一份HTML*/
        String html = "";
        html += "<!DOCTYPE html>";
        html += "<html lang=\"zh_CN\">";
        html += "<head>";
        html += "    <meta charset=\"UTF-8\">";
        html += "    <title>Title</title>";
        html += "</head>";
        html += "<body>";
        html += "<table><tr><td>订单id</td><td>状态</td><td>成员id</td></tr>";
        for (Order order: orderList) {
//            html += "<div>"+ order.getOrderId() +"</div>"+ "<div>"+ order.getStatus() +"</div>" +"<div>"+ order.getMemberId() +"</div>";
            html += "<tr><td>"+ order.getOrderId() +"</td><td>"+ order.getStatus() +"</td><td>"+ order.getMemberId() +"</td></tr>";
        }
        html += "</table>";
        html += "</body>";
        html += "</html>";
        /*3、将拼接的html发送给浏览器*/
        //设置响应格式
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print(html);
        out.close();
    }
}
