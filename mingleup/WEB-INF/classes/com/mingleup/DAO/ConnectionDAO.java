package com.mingleup.DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;




public class ConnectionDAO {
    //Logger log = Logger.getRootLogger();
	static Logger log = Logger.getLogger(ConnectionDAO.class.getName());
       
   public Connection getConnection() throws IOException {
   //Connection conn = null;
   Connection conn = null;
	Context initContext;
	try {
		initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/UsersDB");
		conn = ds.getConnection();
		 //log = Logger.getLogger(ConnectionDAO.class);
        //Logger.getRootLogger().info("driver loaded");
		log.info("DriverLoded");
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return conn;
	
           /*    File file = new File("/home/ravali/workspace/hell/PickMyReels/WebContent/config.properties");
                 FileInputStream fileInput = new FileInputStream(file);
                 Properties properties = new Properties();
                 properties.load(fileInput);
                 fileInput.close();

                 Enumeration enuKeys = properties.keys();
            
                 url = properties.getProperty("url");
                  user = properties.getProperty("user");
                 password = properties.getProperty("password");
  
       try {
           // load driver
           Class.forName("com.mysql.jdbc.Driver");
           log = Logger.getLogger(ConnectionDAO.class);
           Logger.getRootLogger().info("driver loaded");
           System.out.println("driver loaded");

           // create connection
           conn = DriverManager.getConnection(url, user, password);
           System.out.println("successfully connected");
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }

       return conn;*/

   }

}