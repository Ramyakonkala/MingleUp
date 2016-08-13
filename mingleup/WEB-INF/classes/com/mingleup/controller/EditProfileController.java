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


public class EditProfileController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result;
		HttpSession hs = request.getSession();
		String user = (String) hs.getAttribute("sname");
		int user_id = (Integer) hs.getAttribute("suser_id");
		
		String email = request.getParameter("email");
		String DOB = request.getParameter("DOB");
		String gender = request.getParameter("gender");
		String password = null;
		UserDAO contact;
		try {
			contact = new UserDAO();
			UserBean cBean = new UserBean(user,password, email,DOB,gender);
			result = contact.editProfile(user_id,cBean);			
			if(result == 1){
				response.sendRedirect("viewProfile.jsp?msg=Profile Sucessfully changed!!");
			}
			else{
				response.sendRedirect("editProfile.jsp?msg=failed to update!! Try again...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}


