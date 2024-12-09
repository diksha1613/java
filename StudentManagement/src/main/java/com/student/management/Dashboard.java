package com.student.management;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Dashboard extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);

		if (session != null && session.getAttribute("user") != null) {

			if (session.getAttribute("loginSuccess") == null) {

				session.setAttribute("loginSuccess", "You have been successfully logged in");
			}

			req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
		} else {

			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
