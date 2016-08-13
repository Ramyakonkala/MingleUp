package com.mingleup.DAO;

//import java.sql.Array;
//import java.sql.Blob;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
//import java.util.Iterator;
import java.util.List;

//import javax.servlet.http.HttpSession;


import javax.servlet.http.HttpSession;

import com.mingleup.models.ActiveFriendBean;
import com.mingleup.models.GalleryBean;
import com.mingleup.models.SuggestedBean;
//import java.sql.*;
import com.mingleup.models.UploadBean;
import com.mingleup.models.UserBean;

public class UserDAO {
	Statement st = null;
	Connection conn = null;

	public UserDAO() throws SQLException, IOException {
		ConnectionDAO connDAO = new ConnectionDAO();
		conn = connDAO.getConnection();
		st = conn.createStatement();
	}

	public int createUser(UserBean uBean) {
		int result = 0;
		System.out.println("crete user");
		String user = uBean.getUser();
		String password = uBean.getPassword();
		String email = uBean.getEmail();
		String DOB = uBean.getDOB();
		String gender = uBean.getGender();
		String dp = "/images/loginpic.png";
		String query = "INSERT INTO users (username,password,email,date,gender,dp) VALUES ('"
				+ user
				+ "','"
				+ password
				+ "','"
				+ email
				+ "','"
				+ DOB
				+ "','"
				+ gender + "','" + dp + "')";

		System.out.println(st);
		// execute query
		System.out.println(result);
		try {
			result = st.executeUpdate(query);

		} catch (SQLException e1) {
			result = 0;

			e1.printStackTrace();
		}
		System.out.println(result);
		return result;

	}

	public int getUserId(String username) throws SQLException {
		int id = 0;
		ResultSet rs = null;
		String sql = "SELECT user_id FROM users where username='" + username
				+ "'";
		System.out.println("connected");
		rs = st.executeQuery(sql);
		if (rs.next()) {
			id = rs.getInt("user_id");
			System.out.println(id);
		}
		System.out.println(id);
		return id;

	}

	public boolean validateUser(String username, String password)
			throws SQLException {
		ResultSet rs = null;
		String sql = "SELECT * FROM users";
		System.out.println("connected");
		rs = st.executeQuery(sql);
		System.out.println("query excecuted");
		while (rs.next()) {
			String first = rs.getString("username");
			String last = rs.getString("password");
			if (username.equals(first) && password.equals(last)) {
				rs.close();
				return true;
			}
		}
		return false;
	}

	public int SetProfilePic(String img, int user_id) throws SQLException {
		String query = "update users set dp='"+img+"' where user_id="+user_id+";";// insert into upload(comment,img,user_id,dateTime) values('','"+img+"',"+user_id+",now());";
		int result = st.executeUpdate(query);
		if (result >= 1) {
			System.out.println("Record updated");
		} else {
			System.out.println("Record not updated");
			conn.close();
			st.close();
			return 0;
		}
		conn.close();
		st.close();
		return result;

	}

	public String getProfilePic(int user_id) throws SQLException {
		String dp = null;
		String query = "select dp from users where user_id=" + user_id + ";";
		ResultSet rs = null;
		rs = st.executeQuery(query);
		while (rs.next()) {
			dp = rs.getString("dp");

		}

		return dp;

	}

	public int updateUser(String user, String pwd1, String pwd2)
			throws SQLException {
		String query = "update users set password='" + pwd2
				+ "' where username='" + user + "' && password='" + pwd1 + "';";
		int result = st.executeUpdate(query);
		if (result >= 1) {
			System.out.println("Record updated");
		} else {
			System.out.println("Record not updated");
			conn.close();
			st.close();
			return 0;
		}
		conn.close();
		st.close();
		return 1;
	}

	public int insertImg(UploadBean upload) {
		int insertStatus = 0;
		// PreparedStatement preparedStatement = null;

		try {

			String query = "insert into upload (comment,img,user_id,dateTime) values('"
					+ upload.getComment()
					+ "','"
					+ upload.getImage()
					+ "',"
					+ upload.getUser_id() + "," + "NOW())";

			insertStatus = st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		// closing connections
		finally {
			try {

				if (null != st) {
					st.close();

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}

		return insertStatus;

	}

	public List<GalleryBean> displayGallery(int user_id, String query) {
		List<GalleryBean> list = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				list = new ArrayList<GalleryBean>();
				resultSet.beforeFirst();
			}

			while (resultSet.next()) {
				GalleryBean gb = new GalleryBean();

				gb.setComment(resultSet.getString("comment"));
				gb.setImage(resultSet.getString("img"));
				gb.setDateTime(resultSet.getString("dateTime"));
				gb.setUser_id(resultSet.getInt("user_id"));
				gb.setUsername(resultSet.getString("username"));
				gb.setDp(resultSet.getString("dp"));
				System.out.println("this is date"
						+ resultSet.getString("dateTime"));
				list.add(gb);
				System.out.println(list);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e);

		} finally {
			try {
				if (null != preparedStatement) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;
	}

	public List<UploadBean> displayImg(int user_id, String query) {
		List<UploadBean> list = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				list = new ArrayList<UploadBean>();
				resultSet.beforeFirst();
			}

			while (resultSet.next()) {

				UploadBean upload = new UploadBean();
				upload.setComment(resultSet.getString("comment"));
				upload.setImage(resultSet.getString("img"));
				upload.setDateTime(resultSet.getString("dateTime"));
				// upload.setComment(resultSet.getString("user_id"));
				upload.setUsername(resultSet.getString("username"));
				upload.setDp(resultSet.getString("dp"));
				upload.setUser_id(resultSet.getInt("user_id"));
				System.out.println("this is date"
						+ resultSet.getString("dateTime"));
				list.add(upload);
				System.out.println(list);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println(e);

		} finally {
			try {
				if (null != preparedStatement) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;
	}

	public int editProfile(int user_id, UserBean cBean) throws SQLException {
		int result;
		// String user = cBean.getUser();
		String username = cBean.getUser();
		String email = cBean.getEmail();
		String DOB = cBean.getDOB();
		String gender = cBean.getGender();
		String query = "UPDATE users set username ='" + username + "',email='"
				+ email + "',date='" + DOB + "',gender='" + gender
				+ "' where user_id ='" + user_id + "'";
		result = st.executeUpdate(query);
		if (result >= 1) {
			System.out.println("profile updated");
		} else {
			System.out.println("profile not updated");
			conn.close();
			st.close();
			result = 0;
		}
		conn.close();
		st.close();
		return result;
	}

	public List<UserBean> listContact(String user) throws SQLException,
			ClassNotFoundException {
		List<UserBean> conCollection = new ArrayList<UserBean>();
		String query = "SELECT * FROM users where username ='" + user + "'";
		ResultSet result = st.executeQuery(query);
		UserBean ubean;
		while (result.next()) {
			// Retrieve by column name

			String password = result.getString("password");
			String username = result.getString("username");
			String email = result.getString("email");
			String DOB = result.getString("date");
			String gender = result.getString("gender");
			ubean = new UserBean(username, password, email, DOB, gender);
			conCollection.add(ubean);
		}
		System.out.println(conCollection.size());
		return conCollection;
	}

	public List<SuggestedBean> SuggestedFriends(int user_id)
			throws SQLException, ClassNotFoundException {
		List<SuggestedBean> conCollection = new ArrayList<SuggestedBean>();
		System.out.println(user_id + " sfrn");
		String query = "SELECT * FROM users where user_id !='" + user_id + "'";
		ResultSet result = st.executeQuery(query);
		// UserBean ubean;
		SuggestedBean sBean;
		String password = null;
		while (result.next()) {
			// Retrieve by column name

			int userId = result.getInt("user_id");

			String username = result.getString("username");
			String email = result.getString("email");
			String DOB = result.getString("date");
			String gender = result.getString("gender");
			String dp = result.getString("dp");
			sBean = new SuggestedBean(userId, username, email, DOB, gender,dp);
			conCollection.add(sBean);
			// conCollection.add(sBean);
		}
		System.out.println(conCollection.size());
		return conCollection;
	}

	public int loggedIn(int user_id) {
		int insertStatus = 0;
		// PreparedStatement preparedStatement = null;

		try {

			String query = "insert into activefriends values(" + user_id + ")";

			insertStatus = st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		// closing connections
		finally {
			try {

				if (null != st) {
					st.close();
					conn.close();
					st.close();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}

		return insertStatus;
	}
	
	public List<ActiveFriendBean> activeFriends(int user_id,String query) {
		List<ActiveFriendBean> list = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = conn.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				list = new ArrayList<ActiveFriendBean>();
				resultSet.beforeFirst();
			}
			ActiveFriendBean afb;
			while (resultSet.next()) {
				afb = new ActiveFriendBean();
				afb.setUsername(resultSet.getString("username"));
				System.out.println(resultSet.getString("username"));
				afb.setUser_id(resultSet.getInt("user_id"));
				afb.setDp(resultSet.getString("dp"));
				list.add(afb);
			}
		} catch (SQLException e) {
				System.out.println(e);

		} finally {
			try {
				if(conn!=null){
					conn.close();
					
				}
				if(resultSet!=null){
					resultSet.close();
				}
				if (null != preparedStatement) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;
	}
	public int inactivateFriends(int user_id) throws SQLException {
	String query = "delete from activefriends where user_id="+user_id+";";
   int result = st.executeUpdate(query);  
   System.out.println("Query delete excecuted");
   System.out.println(result);
   if(conn != null){
	   conn.close();
   }
   if(st != null){
	   st.close();
   }
  
	
	
   System.out.println(result);
	return result;

}



}
