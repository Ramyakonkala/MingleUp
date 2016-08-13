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

public class SignupController extends HttpServlet {
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
		int result;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
        System.out.println(username +"in signup");
		String email = request.getParameter("email");
		String DOB = request.getParameter("DOB");
		String gender = request.getParameter("gender");
		HttpSession hs = request.getSession();
		hs.setAttribute("sname", username);
		
		int result2=0;
		try {
			UserDAO ud = new UserDAO();
			
			UserBean uBean = new UserBean(username, password, email, DOB,gender);
			result = ud.createUser(uBean);
			
		//	System.out.println(user_id);
			if (result == 1) {
				int user_id = ud.getUserId(username);
				System.out.println(username);
				System.out.println(user_id);
				hs.setAttribute("suser_id",user_id);
				result2=ud.loggedIn(user_id);
				response.sendRedirect("profilePic.jsp?msg=Sucessfully registered!!");
			} else if (result != 1) {
				response.sendRedirect("signup.jsp?msg=" + username
						+ " already exists! signup with different name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
