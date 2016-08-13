package com.mingleup.controller;

import java.io.File;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mingleup.DAO.UserDAO;
import com.mingleup.models.UploadBean;

@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)
// upload file's size up to 16MB
/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		 	 	
		String UPLOAD_DIRECTORY = "/home/ubuntu/Desktop/eclipse/mingleup/mingleup/WebContent/images";
		 	 	HttpSession hs = request.getSession();
		 	 	int user_id = (Integer) hs.getAttribute("suser_id");
		        if(ServletFileUpload.isMultipartContent(request)){
		            try {
		                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		                UploadBean upload = new UploadBean();
		                for(FileItem item : multiparts){
		                    if(!item.isFormField()){
		                        String name = new File(item.getName()).getName();
		                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
		                    }
		                }
		                for(FileItem fileItem:multiparts){
		                	if(fileItem.getFieldName().equals("comment")){
			                    upload.setComment(fileItem.getString());
			                }		                
		                if(fileItem.getFieldName().equals("img")){
		                 upload.setImage("/images/"+fileItem.getName());
		                }
		                upload.setUser_id(user_id);
		                upload.setDateTime(null);
		                
		                }
		                UserDAO ud = new UserDAO();
		                int result=0;
		                result = ud.insertImg(upload);
			            if(result > 0) {
							response.sendRedirect("Home?alert=successfully uploaded!!");
						}
				        else {
							response.sendRedirect("Home?alert=file cannot be uploaded");
						}
		            }
			        catch (Exception e) {
			        	response.sendRedirect("Home?alert=choose a pic before posting");
			            e.printStackTrace();
			        }
		        }
	}
}