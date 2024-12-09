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
import javax.servlet.http.HttpSession;

import com.student.management.DataConn;
import com.student.management.User;

public class Update extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String stdId = req.getParameter("std");
		String password = req.getParameter("pwd");

		// Retrieve the current user session
		HttpSession session = req.getSession();
		User currentUser = (User) session.getAttribute("user");

		// Update the database if the user is logged in
		if (currentUser != null && currentUser.getStdId().equals(stdId)) {
			try (Connection conn = DataConn.getConnection()) {
				// Update user information in the database
				String sql = "UPDATE students SET name = ?, phone = ?, std_id = ?, password = ? WHERE email = ?";

				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, name);
				stmt.setString(2, phone);
				stmt.setString(3, stdId);
				stmt.setString(4, password);
				stmt.setString(5, email);

				int rowsUpdated = stmt.executeUpdate();

				if (rowsUpdated > 0) {
					// Update the session user information
					currentUser.setName(name);
					
					currentUser.setPhone(phone);
					currentUser.setPassword(password);
					session.setAttribute("user", currentUser);
					resp.sendRedirect("dashboard.jsp");
				} else {
					resp.sendRedirect("error.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resp.sendRedirect("error.jsp");
			}

		} else {
			resp.sendRedirect("login.jsp");

		}

	}

}
