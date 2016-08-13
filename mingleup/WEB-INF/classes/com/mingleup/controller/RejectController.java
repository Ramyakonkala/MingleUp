package com.mingleup.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mingleup.DAO.FriendDAO;

public class RejectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int friendid = Integer.parseInt(request.getParameter("friendid"));
		HttpSession hs = request.getSession();
		int user_id = (Integer) hs.getAttribute("suser_id");
		int result;
		
			try {
				FriendDAO fdao = new FriendDAO();
				result = fdao.rejectRequest(friendid, user_id);
				if(result >= 1){
					response.sendRedirect("friendRequest.jsp?msg=Request rejected");
				}
				else if(result != 1){
					response.sendRedirect("friendRequest.jsp?msg=Unable to reject");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}

	
}
