package com.mingleup.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mingleup.DAO.UserDAO;

/**
 * Servlet implementation class InactivateUser
 */
public class InactivateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);// TODO Auto-generated method stub
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession hs = request.getSession();
        System.out.println("loc");
        int user_id = (Integer) hs.getAttribute("user_id");
        System.out.println(user_id);
       
		
			int result;
			try {
				UserDAO ud = new UserDAO();
				result = ud.inactivateFriends(user_id);
				if(result>0){
					 response.sendRedirect("LogoutController");
				}
				else{
					 response.sendRedirect("login.jsp");
				}
	       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
