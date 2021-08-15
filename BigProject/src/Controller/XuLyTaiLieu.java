package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import models.ChiTietBao_TapChi;
import models.ChiTietSach;
import models.DanhMucSach;
import models.LoaiTaiLieu;
import models.TacGia;
//import models.LoaiTaiLieu;
import models.TaiLieu;
import models.ThongTinBao_TapChi;
import models.ThongTinSach;
import utils.ConnecTionManager;

public class XuLyTaiLieu {
	private Connection con;
	public void XulyTaiLieu(){
		con = ConnecTionManager.getConnection();
	}
	public ArrayList<TaiLieu> findAll(){
		ArrayList<TaiLieu> ds = new ArrayList<>();
		String sql = "select * from TAILIEU";
		try {
			con = ConnecTionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				TaiLieu ls = new TaiLieu(rs.getString("matl"), rs.getString("tentl"), null);
				ds.add(ls);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		};
		return ds;
	}
	
	public ArrayList<ThongTinBao_TapChi> findTaiLieuBao(){
		ArrayList<ThongTinBao_TapChi> ds = new ArrayList<>();
		String sql = "SELECT * FROM  THONGTINBAO_TAPCHI";
		//SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
		try {
			con = ConnecTionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				//String ngay = rs.getString("NgayXuatBan");
				//Date dngayxb = sdf.parse(ngay);
				//LoaiTaiLieu loai = new LoaiTaiLieu();
				ThongTinBao_TapChi d = new ThongTinBao_TapChi(rs.getString("matl"), rs.getString("tentl"), rs.getInt("namph"), rs.getInt("kyxb"));
				ds.add(d);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		} 
		return ds;
		
	}
	
	public ArrayList<ThongTinSach> findTaiLieuSach(){
		ArrayList<ThongTinSach> dss = new ArrayList<>();
		String sql = "SELECT * FROM  THONGTINSACH";
		try {
			con = ConnecTionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				ThongTinSach t = new ThongTinSach(rs.getString("matl"), rs.getString("masach"), rs.getString("tinhtrang"), rs.getString("tentl"), rs.getString("tentg"), rs.getString("matg"), rs.getInt("namxb"), rs.getInt("lanxb"), rs.getString("nhaxb"), rs.getInt("sotrang"), rs.getString("khogiay"), rs.getInt("gia"), rs.getString("cocd"), rs.getInt("soluongsach"));
				dss.add(t);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		return dss;
		
	}
	
	public  ArrayList<ThongTinSach> search(String chuoidk) {
		ArrayList<ThongTinSach> ds = new ArrayList<ThongTinSach>();
		String sql = "SELECT * FROM THONGTINSACH WHERE masach like ? OR tentl like ? or tentg like ?";
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			
			
			pst.setString(1, "%"+chuoidk+"%");
			pst.setString(2, "%"+chuoidk+"%");
			pst.setString(3, "%"+chuoidk+"%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				
				ThongTinSach t = new ThongTinSach(rs.getString("matl"), rs.getString("masach"), rs.getString("tinhtrang"), rs.getString("tentl"), rs.getString("tentg"), rs.getString("matg"), rs.getInt("namxb"), rs.getInt("lanxb"), rs.getString("nhaxb"), rs.getInt("sotrang"), rs.getString("khogiay"), rs.getInt("gia"), rs.getString("cocd"), rs.getInt("soluongsach"));
				ds.add(t);
			}
			
		}catch (SQLException e){
			e.printStackTrace();
			//return false;
		} 
		return ds;
	}
	
	public  ArrayList<ThongTinBao_TapChi> searchBao(String chuoidkBao) {
		ArrayList<ThongTinBao_TapChi> ds = new ArrayList<ThongTinBao_TapChi>();
		String sql = "SELECT * FROM THONGTINBAO_TAPCHI WHERE matl like ? OR tentl like ?";
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			
			
			pst.setString(1, "%"+chuoidkBao+"%");
			pst.setString(2, "%"+chuoidkBao+"%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()){
				
				ThongTinBao_TapChi d = new ThongTinBao_TapChi(rs.getString("matl"), rs.getString("tentl"), rs.getInt("namph"), rs.getInt("kyxb"));
				ds.add(d);
			}
			
		}catch (SQLException e){
			e.printStackTrace();
			//return false;
		} 
		return ds;
	}
	
	
	public ArrayList<ChiTietSach> findAllChiTietSach(){
		ArrayList<ChiTietSach> dss = new ArrayList<>();
		String sql = "SELECT * FROM  CHITIETSACH";
		try {
			con = ConnecTionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				TacGia tacGia = new TacGia();
				tacGia.setMaTacGia(rs.getString("matg"));
				ChiTietSach t = new ChiTietSach(rs.getString("masach"),tacGia, rs.getInt("namxb"), rs.getInt("lanxb"), rs.getString("nhaxb"), rs.getInt("sotrang"), rs.getString("khogiay"), rs.getInt("gia"), rs.getString("cocd"), rs.getInt("soluongsach"));
				dss.add(t);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		return dss;
		
	}
	
	public boolean insert(ChiTietSach d){
		String sql = "insert into CHITIETSACH values(?,?,?,?,?,?,?,?,?,?)";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, d.getMaSach());
			pst.setString(2, d.getTacGia().getMaTacGia());
			pst.setInt(3, d.getNamXB());
			pst.setInt(4, d.getLanXB());
			pst.setString(5, d.getNhaXB());
			pst.setInt(6, d.getSoTrang());
			pst.setString(7, d.getKhoGiay());
			pst.setInt(8, d.getGia());
			pst.setString(9, d.getCoCD());
			pst.setInt(10, d.getSoLuongSach());
			boolean kq = pst.execute();
			return kq;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(ChiTietSach d){
		String sql = "update CHITIETSACH set namxb=?, lanxb=?, nhaxb=?, sotrang=?, khogiay=?, gia=?, cocd=?, soluongsach=? where masach=?";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
		
			
			//pst.setString(2, d.getTacGia().getMaTacGia());
			pst.setInt(1, d.getNamXB());
			pst.setInt(2, d.getLanXB());
			pst.setString(3, d.getNhaXB());
			pst.setInt(4, d.getSoTrang());
			pst.setString(5, d.getKhoGiay());
			pst.setInt(6, d.getGia());
			pst.setString(7, d.getCoCD());
			pst.setInt(8, d.getSoLuongSach());
			pst.setString(9, d.getMaSach());
			boolean kq = pst.execute();
			return kq;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void delete(ChiTietSach d){
		String sql = "delete from CHITIETSACH where masach=?";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, d.getMaSach());
			pst.execute();
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
			//return false;
		}
	}
	
	public ArrayList<TaiLieu> findAllTaiLieuSach(){
		ArrayList<TaiLieu> ds = new ArrayList<>();
		String sql = "select * from TAILIEU where MALOAI like 'SACH'";
		try {
			con = ConnecTionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				TaiLieu ls = new TaiLieu(rs.getString("matl"), rs.getString("tentl"), null);
				ds.add(ls);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		};
		return ds;
	}
	
	public boolean insertTaiLieu(TaiLieu d){
		String sql = "insert into TAILIEU values(?,?,'SACH')";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, d.getMaTL());
			pst.setString(2, d.getTenTL());
			//pst.setString(3, d.getLoaiTaiLieu().getMaLoaiTL());
			boolean kq = pst.execute();
			return kq;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateTaiLieu(TaiLieu d){
		String sql = "update TAILIEU set TENTL=? where MATL=?";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
		
			
			//pst.setString(2, d.getTacGia().getMaTacGia());
			pst.setString(1, d.getTenTL());
			pst.setString(2, d.getMaTL());
			
			boolean kq = pst.execute();
			return kq;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void deleteTaiLieu(TaiLieu d){
		String sql = "delete from TAILIEU where matl=?";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, d.getMaTL());
			pst.execute();
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
			//return false;
		}
	}
	
	public ArrayList<ChiTietSach> findAllMaSach (){
		ArrayList<ChiTietSach> ds = new ArrayList<>();
		String sql = "select * from CHITIETSACH";
		try {
			con = ConnecTionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				TacGia tacGia = new TacGia();
				tacGia.setMaTacGia(rs.getString("matg"));
				ChiTietSach t = new ChiTietSach(rs.getString("masach"),tacGia, rs.getInt("namxb"), rs.getInt("lanxb"), rs.getString("nhaxb"), rs.getInt("sotrang"), rs.getString("khogiay"), rs.getInt("gia"), rs.getString("cocd"), rs.getInt("soluongsach"));
				ds.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		};
		return ds;
	}
	
	public ArrayList<DanhMucSach> findAllMaTLByIDMaSach ( String masach){
		ArrayList<DanhMucSach> ds = new ArrayList<>();
		String sql = "select * from DANHMUCSACH where MASACH = '"+masach+"'";
		try {
			con = ConnecTionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				
				ChiTietSach chiTietSach = new ChiTietSach();
				DanhMucSach t = new DanhMucSach(rs.getString("matl"), chiTietSach, rs.getString("tinhtrang"));
				ds.add(t);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
		
		return ds;
	}
	
	public boolean insertDanhMucSach (DanhMucSach d){
		String sql = "insert into DANHMUCSACH values(?,?,?)";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, d.getMatl());
			pst.setString(2, d.getChiTietSach().getMaSach());
			pst.setString(3, d.getTinhTrang());
			//pst.setString(3, d.getLoaiTaiLieu().getMaLoaiTL());
			boolean kq = pst.execute();
			return kq;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateDanhMucSach(DanhMucSach d){
		String sql = "update DANHMUCSACH set TINHTRANG=? where MATL=?";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
		
			
			//pst.setString(2, d.getTacGia().getMaTacGia());
			pst.setString(1, d.getTinhTrang());
			pst.setString(2, d.getMatl());
			//pst.setString(3, d.getChiTietSach().getMaSach());
			
			boolean kq = pst.execute();
			return kq;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void deleteDanhMucSach(DanhMucSach d){
		String sql = "delete from DANHMUCSACH where matl=?";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, d.getMatl());
			pst.execute();
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
			//return false;
		}
	}
	
	public ArrayList<TaiLieu> findAllTaiLieuBao(){
		ArrayList<TaiLieu> ds = new ArrayList<>();
		String sql = "select * from TAILIEU where MALOAI like 'BAOTC'";
		try {
			con = ConnecTionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				TaiLieu ls = new TaiLieu(rs.getString("matl"), rs.getString("tentl"), null);
				ds.add(ls);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		};
		return ds;
	}
	
	public boolean insertTaiLieuBao(TaiLieu d){
		String sql = "insert into TAILIEU values(?,?,'BAOTC')";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, d.getMaTL());
			pst.setString(2, d.getTenTL());
			//pst.setString(3, d.getLoaiTaiLieu().getMaLoaiTL());
			boolean kq = pst.execute();
			return kq;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateTaiLieuBao(TaiLieu d){
		String sql = "update TAILIEU set TENTL=? where MATL=?";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
		
			
			//pst.setString(2, d.getTacGia().getMaTacGia());
			pst.setString(1, d.getTenTL());
			pst.setString(2, d.getMaTL());
			
			boolean kq = pst.execute();
			return kq;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void deleteTaiLieuBao(TaiLieu d){
		//XOA CHITIETBAO_TAPCHI
		String sql = "delete from CHITIETBAO_TAPCHI where matl=?";
		//String sql = "delete from TAILIEU where matl=?";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, d.getMaTL());
			pst.execute();
			//XOA TAI LIEU
			sql = "delete from TAILIEU where matl=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, d.getMaTL());
			pst.execute();
			
			
		}catch (SQLException e){
			e.printStackTrace();
			//return false;
		}
	}
	
	public ArrayList<ChiTietBao_TapChi> findAllChiTietBao(){
		ArrayList<ChiTietBao_TapChi> ds = new ArrayList<>();
		String sql = "select * from CHITIETBAO_TAPCHI";
		try {
			con = ConnecTionManager.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				ChiTietBao_TapChi ls = new ChiTietBao_TapChi(rs.getString("matl"), rs.getInt("namph"), rs.getInt("kyxb"));
				ds.add(ls);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		};
		return ds;
	}
	
	public boolean insertChiTietBao(ChiTietBao_TapChi d){
		String sql = "insert into CHITIETBAO_TAPCHI values(?,?,?)";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, d.getMatl());
			pst.setInt(2, d.getNamPhatHanh());
			pst.setInt(3, d.getKyxb());
			boolean kq = pst.execute();
			return kq;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateChiTietBao(ChiTietBao_TapChi d){
		String sql = "update ChiTietBao_TapChi set NAMPH=?, KYXB=? where MATL=?";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
		
			
			pst.setInt(1, d.getNamPhatHanh());
			pst.setInt(2, d.getKyxb());
			pst.setString(3, d.getMatl());
			
			boolean kq = pst.execute();
			return kq;
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public void deleteChiTietBao(ChiTietBao_TapChi d){
		String sql = "delete from CHITIETBAO_TAPCHI where matl=?";
		
		try{
			con = ConnecTionManager.getConnection();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, d.getMatl());
			pst.execute();
			
			
			
		}catch (SQLException e){
			e.printStackTrace();
			//return false;
		}
	}
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
