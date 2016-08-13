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
import com.mingleup.models.UploadBean;

/**
 * Servlet implementation class RetriveServlet
 */
public class RetriveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
        	query = "select comment,img,user_id,dateTime from upload where user_id="+user_id+" order by dateTime desc";
            list = ud.displayGallery(user_id,query);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.setAttribute("list", list);
        
        RequestDispatcher rd = request.getRequestDispatcher("gallery.jsp");
        rd.forward(request, response);
    }
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
