package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.LoaiTaiLieu;
import models.TaiLieu;
import utils.ConnecTionManager;

public class XuLyTaiLieu {
	Connection con = ConnecTionManager.getConnection();
	
	public ArrayList<TaiLieu> findAll(){
		ArrayList<TaiLieu> ds = new ArrayList<>();
		String sql = "select * from TAILIEU";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			LoaiTaiLieu loai = new LoaiTaiLieu();
			while (rs.next()){
				TaiLieu tl = new TaiLieu(rs.getString("MATL"), rs.getString("TENTL"), loai);
				ds.add(tl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return ds;
	}
	/*Có thể gộp phương thức tìm kiếm (tìm theo mã, tên hoặc tác giả) thành 1 nút, để không 
	gian còn lại dành cho nút Tìm tiếp*/
	public ArrayList<TaiLieu> findTaiLieuByMATL(String ma){
		ArrayList<TaiLieu> ds = new ArrayList<>();
		String sql = "select * from TAILIEU where MATL='"+ ma + "'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			LoaiTaiLieu loai = new LoaiTaiLieu();
			while (rs.next()){
				TaiLieu tl = new TaiLieu(rs.getString("MATL"), rs.getString("TENTL"), loai);
				ds.add(tl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Không có mã sách hiện tại trong danh sách");
		}
		return ds;
	}
	public ArrayList<TaiLieu> findTaiLieuByTENTL(String ten){
		ArrayList<TaiLieu> ds = new ArrayList<>();
		String sql = "select * from TAILIEU where TENTL=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ten);
			ResultSet rs = pst.executeQuery();
			LoaiTaiLieu loai = new LoaiTaiLieu();
			while (rs.next()){
				TaiLieu tl = new TaiLieu(rs.getString("MATL"), rs.getString("TENTL"), loai);
				ds.add(tl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Không có mã sách hiện tại trong danh sách");
		}
		return ds;
	}
}
