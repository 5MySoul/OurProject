package models;

import java.util.ArrayList;

public class ChiTietSach {
	private String maSach;
	private TacGia tacGia;
	private int namXB, lanXB;
	private String nhaXB;
	private int soTrang;
	private String khoGiay;
	private int gia;
	private String coCD;
	private int soLuongSach;
	public ArrayList<DanhMucSach> getDanhMucSachs() {
		return danhMucSachs;
	}
	public void setDanhMucSachs(ArrayList<DanhMucSach> danhMucSachs) {
		this.danhMucSachs = danhMucSachs;
	}
	//Thêm 1 danh mục sách vào chi tiết sách
		public void add (DanhMucSach danhmucsach){
			danhMucSachs.add(danhmucsach);
		}
		//bỏ 1 danh mục sách khỏi chi tiết sách
		public void remove (DanhMucSach danhmucsach){
			danhMucSachs.remove(danhmucsach);
		}
	private ArrayList<DanhMucSach> danhMucSachs = new ArrayList<DanhMucSach>();
	public ChiTietSach(String maSach, TacGia tacGia, int namXB, int lanXB, String nhaXB, int soTrang, String khoGiay,
			int gia, String coCD, int soLuongSach) {
		super();
		this.maSach = maSach;
		this.tacGia = tacGia;
		this.namXB = namXB;
		this.lanXB = lanXB;
		this.nhaXB = nhaXB;
		this.soTrang = soTrang;
		this.khoGiay = khoGiay;
		this.gia = gia;
		this.coCD = coCD;
		this.soLuongSach = soLuongSach;
	}
	public ChiTietSach() {
		super();
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public TacGia getTacGia() {
		return tacGia;
	}
	public void setTacGia(TacGia tacGia) {
		this.tacGia = tacGia;
	}
	public int getNamXB() {
		return namXB;
	}
	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}
	public int getLanXB() {
		return lanXB;
	}
	public void setLanXB(int lanXB) {
		this.lanXB = lanXB;
	}
	public String getNhaXB() {
		return nhaXB;
	}
	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public String getKhoGiay() {
		return khoGiay;
	}
	public void setKhoGiay(String khoGiay) {
		this.khoGiay = khoGiay;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getCoCD() {
		return coCD;
	}
	public void setCoCD(String coCD) {
		this.coCD = coCD;
	}
	public int getSoLuongSach() {
		return soLuongSach;
	}
	public void setSoLuongSach(int soLuongSach) {
		this.soLuongSach = soLuongSach;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSach == null) ? 0 : maSach.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietSach other = (ChiTietSach) obj;
		if (maSach == null) {
			if (other.maSach != null)
				return false;
		} else if (!maSach.equals(other.maSach))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ChiTietSach [maSach=" + maSach + "]";
	}
	
	
	
}
