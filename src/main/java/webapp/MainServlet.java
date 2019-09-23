package webapp;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Properties;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import webapp.model.userdata;

@WebServlet(urlPatterns = "/helloworld.do")

public class MainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/front.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String create_usr = System.getProperty("user.name");
		LocalDateTime ldt = LocalDateTime.now();
		
		String usrmessage = request.getParameter("message");
		request.setAttribute("message", usrmessage);
		request.setAttribute("user", create_usr);
		request.setAttribute("timestamp", ldt);
		
		//userdata data = getuserdata();
		//request.setAttribute("userdata", data);		
		request.getRequestDispatcher("/WEB-INF/pages/front.jsp").forward(request, response);

	}
	
//	private void insertData(HttpServletRequest request) {
//		// setup connection.
//		
//		
//		String city = request.getParameter("city");
//		String query = "INSERT INTO <TABLE_NAME> VALUES(?)";
//		
//	}
	
	public userdata getuserdata() {
		
		userdata a = new userdata();
        // Connect to database
        String hostName = "loyaltyone.database.windows.net"; // update me
        String dbName = "userdata"; // update me
        String user = "jackson"; // update me
        String password = "pink09@@"; // update me
        String url = String.format("jdbc:mysql://%s:1433;database=%s;user=%s;password=%s", hostName, dbName, user, password);
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
                
                if (resultSet.next())
                {
                	a.setUsr_comment(resultSet.getString("USR_COMMENT"));
                	System.out.println(resultSet.getString("USR_COMMENT"));
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
