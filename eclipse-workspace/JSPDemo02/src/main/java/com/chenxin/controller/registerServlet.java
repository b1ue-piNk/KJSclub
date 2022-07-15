package com.chenxin.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.chenxin.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
        String rname = req.getParameter("r_name");
        String rpassword = req.getParameter("r_password");
        String s_pw = req.getParameter("r_password2");
        
        if (rname == null || "".equals(rname.trim())) {
        	req.setAttribute("msg", "请输入用户名！");
        	req.getRequestDispatcher("register.jsp").forward(req, resp);
        	return;
        }
        
        if (rpassword == null || "".equals(rpassword.trim())) {
        	req.setAttribute("msg", "请输入密码！");
        	req.getRequestDispatcher("register.jsp").forward(req, resp);
        	return;
        }
        
        if (!s_pw.equals(rpassword)) {
        	req.setAttribute("msg", "密码不一致，请重新输入！");
        	req.getRequestDispatcher("register.jsp").forward(req, resp);
        	return;
        }
        
        UserService us = new UserService();
        try {
        	boolean live = us.if_repete(rname).next();
        	if (live) {
        		req.setAttribute("msg", "账号已存在！");
            	req.getRequestDispatcher("register.jsp").forward(req, resp);
            	return;
        	}
			us.registerService(rname, rpassword);
			resp.sendRedirect("login.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
