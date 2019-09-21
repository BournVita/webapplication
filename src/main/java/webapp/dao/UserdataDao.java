package webapp.dao;
import java.sql.*;

import webapp.model.userdata;


public class UserdataDao {
	
	public userdata getUserdata() {
	
	userdata a = new userdata();
	

	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection coninfo = DriverManager.getConnection("jdbc:mysql://loyaltyone.database.windows.net","jackson","pink09@@");
		Statement query = coninfo.createStatement();
		ResultSet output = query.executeQuery("select usr_comment from dbo.initial_userinfo");
		
	}
	
	catch (Exception e) {
		
		System.out.println(e);
		
		
	}
	
	return a;
	
	}
}
