import java.sql.*;
public class dbHandler {
	Connection con;
	String password;
	String username;
	String dbName = "sys";

	void createConnection(String un,String pw){ // creates connection with db

		 try {
			 password = pw;
			 username = un;
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
			try {
				con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/sys" ,pw,un);
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

	ResultSet executeStatement(String command) throws SQLException{ // execute statement for scrapping stats

		Statement stmt=con.createStatement();
	    return stmt.executeQuery(command);


	}



}
