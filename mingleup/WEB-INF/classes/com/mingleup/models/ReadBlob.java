package com.mingleup.models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadBlob {
	static String url = "jdbc:mysql://localhost:3306/demo";
	static String user = "root";
	static String password = "ramya";
	Connection conn = null;
	
  public static void main(String[] args) throws Exception {

				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("driver loaded");

		    Connection conn = DriverManager.getConnection(url,user, password);

		    
		    FileInputStream fis = null;
		    PreparedStatement ps = null;
		    try {
		      conn.setAutoCommit(false);
		      File file = new File("/home/ubuntu/Desktop/eclipse/mingleup/mingleup/WebContent/images/logo.png");
		      fis = new FileInputStream(file);
		      ps = conn.prepareStatement("insert into upload values (?,?,?,?)");
		      ps.setString(1, "1");
		      ps.setString(2, "name");
		      ps.setBinaryStream(3, fis, (int) file.length());
		      ps.setString(4, "ravali");
		      ps.executeUpdate();
		      conn.commit();
		    } finally {
		      ps.close();
		      fis.close();
		    }
		    
		    
		    
		    
		    String sql = "SELECT img from upload where username='ravali'";
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    ResultSet resultSet = stmt.executeQuery();
		    while (resultSet.next()) {
		      //String name = resultSet.getString(1);
		      //String description = resultSet.get(3);
		      File image = new File("/home/ubuntu/Desktop/eclipse/mingleup/mingleup/WebContent/images/java2.gif");
		      FileOutputStream fos = new FileOutputStream(image);

		      byte[] buffer = new byte[1];
		      InputStream is = resultSet.getBinaryStream(1);
		      while (is.read(buffer) > 0) {
		        fos.write(buffer);
		      }
		      fos.close();
		    }
		    conn.close();
		  }
		}

		   

