package com.lt.jeasyuidemo.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet {

	public Statement servlet() {
			try{
				Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}

			
			String url="jdbc:mysql://localhost:3366/jeasyui";
			String username="root";
			String password="12345";
			Connection conn = null;
			try{
				conn = DriverManager.getConnection(url,username,password);
			}catch(SQLException e){
				e.printStackTrace();
			}
			Statement stmt = null;//向数据库里发sql语句
			try{
				stmt = conn.createStatement();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return stmt;
	}		
}
