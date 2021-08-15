package models;

public class DanhMucSach {
	private String matl;
	private ChiTietSach chiTietSach;
	private String tinhTrang;
	public DanhMucSach(String matl, ChiTietSach chiTietSach, String tinhTrang) {
		super();
		this.matl = matl;
		this.chiTietSach = chiTietSach;
		this.tinhTrang = tinhTrang;
	}
	public DanhMucSach() {
		super();
	}
	public String getMatl() {
		return matl;
	}
	public void setMatl(String matl) {
		this.matl = matl;
	}
	public ChiTietSach getChiTietSach() {
		return chiTietSach;
	}
	public void setChiTietSach(ChiTietSach chiTietSach) {
		this.chiTietSach = chiTietSach;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	@Override
	public String toString() {
		return "DanhMucSach [matl=" + matl + ", tinhTrang=" + tinhTrang + "]";
	}
	
	
}
