package com.mingleup.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mingleup.DAO.UserDAO;
import com.mingleup.models.UserBean;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean result;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession hs = request.getSession();
		hs.setAttribute("sname", username);
		
		UserDAO ud;
		int user_id=0;
		int result2=0;
		try {
			
			
			ud = new UserDAO();
			user_id =ud.getUserId(username);
			
			hs.setAttribute("suser_id",user_id);
			System.out.println("sess"+user_id);
			
			result = ud.validateUser(username, password);

			MingleUpLog log = new MingleUpLog();

			log.write(username);
			if (result) {
				result2=ud.loggedIn(user_id);		
				response.sendRedirect("Home");
			} else {
				response.sendRedirect("login.jsp?username=" + username);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
