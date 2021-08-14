package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import models.MuonTra;
import models.V_MuonTra;
import utils.ConnecTionManager;

public class XuLyMuonTra {
	Connection con = ConnecTionManager.getConnection();
	
	public ArrayList<V_MuonTra> findByMaThe(String ma){
		ArrayList<V_MuonTra> ds = new ArrayList<>();
		String sql = "Select * from V_MUONTRA where MATHE='"+ ma + "'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()){
				Date dngayMuon = rs.getDate("NGAYMUON");
				Date dngayTra = rs.getDate("NGAYTRA");
				V_MuonTra v = new V_MuonTra(rs.getString("MATHE"), rs.getString("TEN"), rs.getString("MATL"), rs.getString("TENTL"), dngayMuon, dngayTra);
				ds.add(v);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	public void delete(String maTL){
		String sql = "DELETE FROM MUONTRA WHERE MATL=?";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, maTL);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insert(MuonTra mt){
		String sql = "insert into MUONTRA values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, mt.getMaThe());
			pst.setString(2, mt.getTailieu().getMaTL());
			pst.setInt(3, mt.getSoLuong());
			java.sql.Date ngayM = new java.sql.Date(mt.getNgaymuon().getTime());
			pst.setDate(4, ngayM);
			java.sql.Date ngayT = new java.sql.Date(mt.getNgaytra().getTime());
			pst.setDate(5, ngayT);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}











