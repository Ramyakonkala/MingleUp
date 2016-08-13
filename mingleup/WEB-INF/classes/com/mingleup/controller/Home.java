package com.mingleup.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mingleup.DAO.UserDAO;
import com.mingleup.models.UploadBean;

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		int user_id = (Integer) hs.getAttribute("suser_id");
		String username = (String) hs.getAttribute("sname");
	    List<UploadBean> list = null;
        try {
      	String query = "select dateTime, up.user_id, img, comment, username,dp from upload up, users where up.user_id in (select friend_one from friends where friend_two= "+user_id+" and status='1' union select friend_two from friends where friend_one="+user_id+" and status='1' union select user_id from users where user_id="+user_id+") and up.user_id=users.user_id order by dateTime desc;";
        	UserDAO ud = new UserDAO();
            list = ud.displayImg(user_id,query);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.setAttribute("list", list);
        if(username != null){
        RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        rd.forward(request, response);
        return;
        }
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
