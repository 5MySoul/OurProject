package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConnecTionManager;

public class ControlAuthentication {
	Connection con = ConnecTionManager.getConnection();
	
	public boolean checkAccount(String u, String pw){
		String sql = "Select * from QUYENTRUYCAP where username=? and password=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, u);
			pst.setString(2, pw);
			ResultSet rs = pst.executeQuery();
			if (rs.next()){
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
