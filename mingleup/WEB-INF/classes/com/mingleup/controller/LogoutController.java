package com.mingleup.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mingleup.DAO.UserDAO;

public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// deleting user from session
        HttpSession hs = request.getSession();
        System.out.println("loc");
       
        try {
        	 if(request.getParameter("user_id")!=null){
        	        int user_id = Integer.parseInt(request.getParameter("user_id"));
        	        System.out.println(user_id);
        	        UserDAO ud = new UserDAO();
        			int result=ud.inactivateFriends(user_id);
        		
        	        }
				hs.removeAttribute("suser");
	        hs.removeAttribute("suser_id");        
	        // calling invalidate() 
	        hs.invalidate();
			 response.sendRedirect("login.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
	}
}
