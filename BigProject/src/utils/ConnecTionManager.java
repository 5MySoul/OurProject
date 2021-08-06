package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnecTionManager {
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url = "jdbc:sqlserver://DESKTOP-THKHMGL\\SQLEXPRESS:1035;databaseName=QLYTHUVIEN_2;useUnicode=true;characterEncoding=UTF-8";
	private static String user = "sa";
	private static String password = "sa";
	
	private static Connection connect=null;
	
	private static void makeConnection()
	{
		try {
			Class.forName(driver);
			connect= DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		if(connect == null){
			makeConnection();
		}
		return connect;
	}
}
