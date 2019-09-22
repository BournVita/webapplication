package webapp;

import java.sql.Connection;
import java.sql.Statement;

//import com.telusko.web.model.Alien;

import webapp.model.userdata;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class App {

	public userdata getuserdata() {
    	
    	userdata a = new userdata();
        // Connect to database
        String hostName = "loyaltyone.database.windows.net"; // update me
        String dbName = "userdata "; // update me
        String user = "jackson"; // update me
        String password = "pink09@@"; // update me
        String url = String.format("jdbc:sqlserver://%s:1433;database=%s;user=%s;password=%s;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url);
            String schema = connection.getSchema();
           // System.out.println("Successful connection" + schema);

            System.out.println("Log");
            System.out.println("=========================================");

            // Create and execute a SELECT SQL statement.
            String selectSql = "select * from dbo.initial_userinfo";

            try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectSql)) {

                // Print results from select statement
                
                while (resultSet.next())
                {
                	a.setUsr_comment(resultSet.getString("USR_COMMENT"));
    				a.setCreate_usr(resultSet.getString("CREATE_USR"));
    				a.setCreate_date(resultSet.getString("CREATE_DATE"));
                }
                connection.close();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		return a;
    }
}