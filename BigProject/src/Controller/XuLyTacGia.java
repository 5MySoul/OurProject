package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.ConnecTionManager;
import models.ChiTietBao_TapChi;
import models.ChiTietSach;
import models.TacGia;

public class XuLyTacGia {
	private Connection con;
	public XuLyTacGia(){
		con = ConnecTionManager.getConnection();
	}
	public ArrayList<TacGia> findAll(){
		ArrayList<TacGia> ds = new ArrayList<>();
		String sql = "select * from tacgia";
		try {
			con = ConnecTionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				TacGia ls = new TacGia(rs.getString("matg"), rs.getString("tentg"), rs.getInt("namsinh"));
				ds.add(ls);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		};
		return ds;
	}
	
	public ArrayList<ChiTietSach> findChiTietSachByID(String matg){
		ArrayList<ChiTietSach> ds = new ArrayList<>();
		String sql = "Select * from CHITIETSACH where MATG = '"+matg+"'";
		
		try {
			con = ConnecTionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				
				TacGia tacGia = new TacGia();
				ChiTietSach t = new ChiTietSach(rs.getString("masach"),tacGia, rs.getInt("namxb"), rs.getInt("lanxb"), rs.getString("nhaxb"), rs.getInt("sotrang"), rs.getString("khogiay"), rs.getInt("gia"), rs.getString("cocd"), rs.getInt("soluongsach"));
				ds.add(t);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		
		return ds;
		
	}
	
	public boolean insertTacGia(TacGia d){
		String sql = "insert into TACGIA values(?,?,?)";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, d.getMaTacGia());
			pst.setString(2, d.getTenTacGia());
			pst.setInt(3, d.getNamsinh());
			boolean kq = pst.execute();
			return kq;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateTacGia(TacGia d){
		String sql = "update TACGIA set TENTG=?, NAMSINH=? where MATG=?";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
		
			
			pst.setString(1, d.getTenTacGia());
			pst.setInt(2, d.getNamsinh());
			pst.setString(3, d.getMaTacGia());
			
			boolean kq = pst.execute();
			return kq;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void deleteTacGia(TacGia d){
		String sql = "delete from TACGIA where MATG=?";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, d.getMaTacGia());
			pst.execute();
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
			//return false;
		}
	}

}
