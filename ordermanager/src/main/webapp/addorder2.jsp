<%@ page import="com.zs.entity.Order" %>
<%@ page import="java.util.UUID" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.zs.util.MyBatisUtil" %>
<%@ page import="com.zs.mapper.OrderMapper" %><%--
  Created by IntelliJ IDEA.
  User: 满面春风遮不住
  Date: 2019/9/17
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addorder2</title>
</head>

<body>
    <form action="addorder" method="get">
        订单状态：<input type="text" name="status">
        用户id：<input type="text" name="memberId">
        <input type="submit">
    </form>
</body>
</html>

