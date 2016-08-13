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
import com.mingleup.models.GalleryBean;

/**
 * Servlet implementation class Timeline
 */
public class Timeline extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Timeline() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		int user_id = (Integer) hs.getAttribute("suser_id");
	String query = null;
	    List<GalleryBean> list = null;
        try {
        	UserDAO ud = new UserDAO();
        //	query = "select comment,img,user_id,dateTime from upload where user_id="+user_id+" order by dateTime desc";
        	query = "select up.comment,up.img,us.user_id,dateTime,us.username,us.dp from upload up,users us where up.user_id="+user_id+" and us.user_id=up.user_id order by up.dateTime desc;";
            list = ud.displayGallery(user_id,query);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.setAttribute("list", list);
        
        RequestDispatcher rd = request.getRequestDispatcher("viewProfile.jsp");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
