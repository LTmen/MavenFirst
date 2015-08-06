package com.lt.jeasyuidemo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lt.jeasyuidemo.pojo.User;
import com.lt.jeasyuidemo.util.JsonUtil;

public class SaveUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("doGet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fristname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		Servlet servlet = new Servlet();
		Statement stmt = servlet.servlet();//向数据库里发sql语句
		String sql="insert into users values(1,'"+fristname+"','"+lastname+"','"+phone+"','"+email+"')";

		ResultSet rs = null;
		List<User> l = new ArrayList<User>();
		try{
			int count=stmt.executeUpdate(sql);
			if(count>0){
				System.out.println("成功");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	
	}
}
