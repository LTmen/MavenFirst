package com.lt.jeasyuidemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * @author Administrator
 *
 */
public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Servlet servlet = new Servlet();
		Statement stmt = servlet.servlet();//向数据库里发sql语句
		
		String sql="select * from users";
		ResultSet rs = null;
		List<User> l = new ArrayList<User>();
		try{
			 rs = stmt.executeQuery(sql);
			 while(rs.next()){
				 User user = new User();
				 user.setId(rs.getInt("id"));
				 user.setFirstname(rs.getString("firstname"));
				 user.setLastname(rs.getString("lastname"));
				 user.setPhone(rs.getString("phone"));
				 user.setEmail(rs.getString("email"));
				 l.add(user);
			 }
		}catch(SQLException e){
			e.printStackTrace();
		}
		for(User i : l){ 
            System.out.println(i); 
        }
		
		String jsonStr = JsonUtil.toJson(l);
		PrintWriter out = resp.getWriter();
		out.print(jsonStr);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}

}
