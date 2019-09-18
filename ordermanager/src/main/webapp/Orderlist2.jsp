<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.zs.util.MyBatisUtil" %>
<%@ page import="com.zs.mapper.OrderMapper" %>
<%@ page import="com.zs.entity.Order" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 满面春风遮不住
  Date: 2019/9/17
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orderlist</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>订单状态</th>
                <th>用户</th>
                <th>创建时间</th>
                <th>修改时间</th>
            </tr>
        </thead>
        <tbody>
        <%
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            List<Order> orderList = orderMapper.listOrder();
        %>
        <%
            for (Order order:orderList) {
        %>
            <tr>
                <td><%out.print(order.getStatus());%></td>
                <td><%out.print(order.getMemberId());%></td>
                <td><%out.print(order.getCreateTime());%></td>
                <td><%out.print(order.getUpdateTime());%></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>

</body>
</html>
