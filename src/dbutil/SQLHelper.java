package dbutil;
import java.sql.*;

public class SQLHelper {
	public static String driver = "com.mysql.jdbc.Driver", 
			url = "jdbc:mysql://127.0.0.1:3306/examappdb", 
			dbuser = "root",
			dbpwd = "heiheihei1234";
	private static Connection conn=null;
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void closeConnection() {
		try {
			if(conn!=null && !conn.isClosed())
		      conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	//÷¥––udate,insert£¨ delete”Ôæ‰
	public static int executeUpdate(String sql) {
		int r=0;
		try {
		    conn = DriverManager.getConnection(url, dbuser, dbpwd);
			Statement cmd = conn.createStatement();
			r= cmd.executeUpdate(sql);
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return r;
	}
	
	//÷¥––Select”Ôæ‰
	public static ResultSet executeQuery(String sql) {
		ResultSet rs=null;
		try {
		    conn = DriverManager.getConnection(url, dbuser, dbpwd);
			Statement cmd = conn.createStatement();
			rs = cmd.executeQuery(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}
}
