package com.mingleup.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mingleup.DAO.UserDAO;

/**
 * Servlet implementation class ViewProfilePic
 */
public class ViewProfilePic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String UPLOAD_DIRECTORY = "/home/ubuntu/Desktop/eclipse/mingleup/mingleup/WebContent/images";
 	 	HttpSession hs = request.getSession();
 	 	String img=null;
 	 	int user_id = (Integer) hs.getAttribute("suser_id");
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
                for(FileItem fileItem:multiparts){
                		                
                if(fileItem.getFieldName().equals("img")){
                 img="/images/"+fileItem.getName();
                }
               
                }
                UserDAO ud = new UserDAO();
                int result=0;
               // result = ud.insertImg(upload);
                result = ud.SetProfilePic(img, user_id);
	            if(result > 0) {
					response.sendRedirect("Timeline?alert=successfully uploaded!!");
				}
		        else {
					response.sendRedirect("Timeline?alert=file cannot be uploaded");
				}
            }
	        catch (Exception e) {
	        	response.sendRedirect("Timeline?alert=choose a pic before posting");
	            e.printStackTrace();
	        }
        }
	}

}
