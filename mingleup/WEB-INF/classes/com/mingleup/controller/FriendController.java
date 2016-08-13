package com.mingleup.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import com.mingleup.DAO.FriendDAO;




public class FriendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int friendId = Integer.parseInt(request.getParameter("friendId"));
		System.out.println(friendId +" frndid");
		HttpSession hs = request.getSession();
		String username = (String)hs.getAttribute("sname");
		int user_id = (Integer) hs.getAttribute("suser_id");
		System.out.println(username);
		try {
			FriendDAO fdao = new FriendDAO();
			int result = fdao.sendRequest(friendId, user_id);
			System.out.println(result);
			
			if(result > 0){
				response.sendRedirect("Home?msg2=Sent successfully");
			}
			else{
				response.sendRedirect("Home?msg= Already sent");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(friendId + "friend id n controller");
	}

}
