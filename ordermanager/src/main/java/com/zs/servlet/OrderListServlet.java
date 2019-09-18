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
import java.io.PrintWriter;
import java.util.List;

public class OrderListServlet extends HttpServlet {
    /**
     *服务器自动调用此方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、查询数据    mybatis
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = orderMapper.listOrder();
        //2、数据库拼接成页面
        String html = "";
        html += "<!DOCTYPE html>";
        html += "<html lang=\"zh_CN\">";
        html += "<head>";
        html += "    <meta charset=\"UTF-8\">";
        html += "    <title>Title</title>";
        html += "</head>";
        html += "<body>";
        html += "<table>";
        html += "<thead>";
        html += "<tr>";
        html += "<th>订单状态</th>";
        html += "<th>用户</th>";
        html += "<th>创建时间</th>";
        html += "<th>修改时间</th>";
        html += "</tr>";
        html += "</thead>";
        html += "<tbody>";

        for (Order order:orderList) {
            html += "<tr>";
            html += "<td>"+ order.getStatus() +"</td>";
            html += "<td>"+ order.getMemberId() +"</td>";
            html += "<td>"+ order.getCreateTime() +"</td>";
            html += "<td>"+ order.getUpdateTime() +"</td>";
            html += "</tr>";
        }


        html += "</tbody>";
        html += "</table>";
        html += "</body>";
        html += "</html>";
        //3、将页面发送给浏览器
        //设置响应格式
        resp.setContentType("text/html;charset=utf-8");
        //获得指向浏览器的输出流
        PrintWriter out = resp.getWriter();
        out.print(html);
        //4、关闭资源
        out.close();
        sqlSession.close();
    }
}
