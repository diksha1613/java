package com.student.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.management.DataConn;

public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String stdId = req.getParameter("std");
		String password = req.getParameter("pwd");

		try (Connection conn = DataConn.getConnection()) {
			String sql = "INSERT INTO students (name, email, phone, std_id, password) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, phone);
			stmt.setString(4, stdId);
			stmt.setString(5, password);
			stmt.executeUpdate();

			resp.sendRedirect("login.jsp?message=Registration Successful!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resp.sendRedirect("error.jsp");
		}

	}
}
