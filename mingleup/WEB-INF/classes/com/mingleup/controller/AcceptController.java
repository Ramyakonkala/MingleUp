package com.mingleup.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mingleup.DAO.FriendDAO;


public class AcceptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doger");
	doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("acontrller doprocess");
		
		int friendid = Integer.parseInt(request.getParameter("friendid"));
		System.out.println(friendid);
		HttpSession hs = request.getSession();
		int user_id = (Integer) hs.getAttribute("suser_id");
		System.out.println(user_id);
		System.out.println(friendid);
		try {
			FriendDAO fdao = new FriendDAO();
			int result = fdao.acceptRequest(friendid, user_id);
			if (result >= 1) {
				response.sendRedirect("friendRequest.jsp");
			} else {
				response.sendRedirect("friendRequest.jsp");
			}
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
