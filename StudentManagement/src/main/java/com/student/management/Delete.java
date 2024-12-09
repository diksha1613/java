package com.student.management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Delete extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Retrieve the current session
		HttpSession session = req.getSession(false);

		if (session != null && session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			String userEmail = user.getEmail();

			// Delete the user from the database
			try (Connection conn = DataConn.getConnection()) {
				String sql = "DELETE FROM students WHERE email = ?";
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, userEmail);

				int rowsDeleted = stmt.executeUpdate();

				if (rowsDeleted > 0) {
					// Invalidate the session
					session.invalidate();
					// Redirect to registration page with success message
					resp.sendRedirect("regi.jsp?message=Record has been deleted");
				} else {
					resp.sendRedirect("error.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
				resp.sendRedirect("error.jsp");
			}
		} else {
			// If session is not found, redirect to login page
			resp.sendRedirect("login.jsp");
		}
	}
}
