import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://DESKTOP-THKHMGL\\SQLEXPRESS:1035;databaseName=QLYTHUVIEN_2;useUnicode=true;characterEncoding=UTF-8";
		String user = "sa";
		String password = "sa";
		try {
			Class.forName(driver);
			Connection connect= DriverManager.getConnection(url, user, password);
			
			System.out.println("Successfully connected");
			Statement stm=connect.createStatement();
			String sql="select * from QUYENTRUYCAP";
			ResultSet rs= stm.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString("USERNAME")+"\t"+ rs.getInt("LEVEL"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}






