package com.mingleup.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mingleup.models.SearchBean;

public class FriendDAO {

	Statement st = null;
	Connection conn = null;

	public FriendDAO() throws SQLException, IOException {
		ConnectionDAO connDAO = new ConnectionDAO();
		conn = connDAO.getConnection();
		st = conn.createStatement();
	}

	public int sendRequest(int friendId, int user_id) {
		int result = 0;
		try {
			String query2 = " INSERT INTO friends (friend_one,friend_two) VALUES ("+user_id+","+friendId+")";
			result = st.executeUpdate(query2);

			System.out.println(user_id + "query");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	public int acceptRequest(int friendId, int user_id) throws SQLException {

		
		 	System.out.println(friendId+"**"+user_id);
		String query = "update friends set status = '1' where friend_one="+friendId+" and friend_two="+user_id+"";
		 //execute query fr1=fid f2=useid r f1
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

	public int rejectRequest(int friendId, int user_id) throws SQLException {
		System.out.println(friendId+"**"+user_id);
		String query = "delete from friends where friend_one="+friendId+" and friend_two="+user_id+"";
		 //execute query fr1=fid f2=useid r f1
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

	public List<SearchBean> listrequest(int user_id,String query) throws SQLException,
			ClassNotFoundException {
		List<SearchBean> conCollection = new ArrayList<SearchBean>();

		
		System.out.println("first query");
		ResultSet result = st.executeQuery(query);
		System.out.println("excecutred");
		String friendname = null;
		int friendid = 0;
		SearchBean contactBean2;
		while (result.next()) {

			friendname = result.getString("username");
			friendid = result.getInt("user_id");
			contactBean2 = new SearchBean(friendname, friendid);
			conCollection.add(contactBean2);

		}
		return conCollection;
	}

}
