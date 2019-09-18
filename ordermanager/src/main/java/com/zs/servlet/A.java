package com.zs.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/a"})
public class A extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("a组建获得的id="+req.getParameter("id"));
        System.out.println("a");
        req.setAttribute("key","1424");
        req.setAttribute("key","1424");
        //获得转发器，参数填写目标地址
        RequestDispatcher rd = req.getRequestDispatcher("b");
        //使用转发器的forward方法进行转发
        rd.forward(req,resp);
    }
}
