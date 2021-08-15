package Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.LoaiTaiLieu;
import models.TaiLieu;
import utils.ConnecTionManager;

public class XuLyLoaiTaiLieu {
	private Connection con;
	public void XulyLoaiTaiLieu(){
		con = ConnecTionManager.getConnection();
	}
	public ArrayList<LoaiTaiLieu> findAll(){
		ArrayList<LoaiTaiLieu> ds = new ArrayList<>();
		String sql = "select * from LOAITAILIEU";
		try {
			con = ConnecTionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				LoaiTaiLieu ls = new LoaiTaiLieu(rs.getString("maloai"), rs.getString("tenloaitl"));
				ds.add(ls);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		};
		return ds;
	}
	
	
	public ArrayList<TaiLieu> findTaiLieuByID(String id){
		ArrayList<TaiLieu> ds = new ArrayList<>();
		String sql = "Select * from TAILIEU where MALOAI = '"+id+"'";
		try {
			con = ConnecTionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				//String ngay = rs.getString("NgayXuatBan");
				//Date dngayxb = sdf.parse(ngay);
				LoaiTaiLieu loai = new LoaiTaiLieu();
				TaiLieu d = new TaiLieu(rs.getString("matl"), rs.getString("tentl"), loai);
				ds.add(d);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		} 
		return ds;
		
	}
	
	
	
	
}
