package com.chenxin.controller;

import java.io.IOException;
import java.sql.SQLException;
import com.chenxin.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {


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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        String uname = request.getParameter("name");
        String upassword = request.getParameter("password");
        
        if (uname == null || "".equals(uname.trim())) {
        	request.setAttribute("msg" , "用户账号不能为空！");
        	request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }
        
        if (upassword == null || "".equals(upassword.trim())) {
        	request.setAttribute("msg" , "用户密码不能为空！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
            return;
        }

        UserService us = new UserService();
        
		try {
			boolean flag = us.getRs(uname, upassword).next();
			if (flag) {
    			response.sendRedirect("index.jsp");
    			return;
    		}
    		else {
    			request.setAttribute("msg" , "用户账号或密码错误");
                request.getRequestDispatcher("login.jsp").forward(request,response);
                return;
    		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("最终步骤连接失败！");
			e.printStackTrace();
		}
        

        		
        
        
        
	}
    
}