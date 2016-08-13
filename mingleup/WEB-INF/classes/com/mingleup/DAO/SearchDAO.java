package com.mingleup.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mingleup.models.SearchBean;
import com.mingleup.models.UploadBean;

public class SearchDAO {

	Statement st=null;
	Connection conn = null;
	
		
	public SearchDAO() throws SQLException, IOException {
		 ConnectionDAO connDAO = new ConnectionDAO();
		 conn = connDAO.getConnection();
		 st = conn.createStatement();
		 }

	public List<SearchBean> listContact(String user) throws SQLException,ClassNotFoundException{
		List<SearchBean> conCollection = new ArrayList<SearchBean>();
		String query = "SELECT * FROM users where username='"+user+"'";
		ResultSet result = st.executeQuery(query);
		//ContactBean contactBean2;
		//String name;
		System.out.println(result+" result");
		SearchBean sbean;
		while(result.next()){
	           //Retrieve by column name
	          
	           String  name = result.getString("username");
	           int id = result.getInt("user_id");
	           sbean =  new SearchBean(name,id);
	       System.out.println("retrived"+name);
	           conCollection.add(sbean);
		}
		System.out.println(conCollection.size());
		return conCollection;
	}/*
	
	*public List<UploadBean> displayImg() throws SQLException {
		List<UploadBean> conCollection = new ArrayList<UploadBean>();
		String query = "SELECT * FROM upload";
		ResultSet result = st.executeQuery(query);
		UploadBean uBean;
		while (result.next()) {
			// Retrieve by column name

			String thumbup = result.getString("thumbup");
			String comment = result.getString("comment");
			byte[] img = result.getBytes("img");
			uBean = new UploadBean(thumbup, comment, img);
			conCollection.add(uBean);
		}
		System.out.println(conCollection.size());

		return conCollection;
	}
	*
	*/

	
	
}
