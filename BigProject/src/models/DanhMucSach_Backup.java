package models;

public class DanhMucSach_Backup {
	private TaiLieu taiLieu;
	private ChiTietSach chiTietSach;
	private String tinhTrang;
	public DanhMucSach_Backup(TaiLieu taiLieu, ChiTietSach chiTietSach, String tinhTrang) {
		super();
		this.taiLieu = taiLieu;
		this.chiTietSach = chiTietSach;
		this.tinhTrang = tinhTrang;
	}
	public DanhMucSach_Backup() {
		super();
	}
	public TaiLieu getTaiLieu() {
		return taiLieu;
	}
	public void setTaiLieu(TaiLieu taiLieu) {
		this.taiLieu = taiLieu;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chiTietSach == null) ? 0 : chiTietSach.hashCode());
		result = prime * result + ((taiLieu == null) ? 0 : taiLieu.hashCode());
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
		DanhMucSach_Backup other = (DanhMucSach_Backup) obj;
		if (chiTietSach == null) {
			if (other.chiTietSach != null)
				return false;
		} else if (!chiTietSach.equals(other.chiTietSach))
			return false;
		if (taiLieu == null) {
			if (other.taiLieu != null)
				return false;
		} else if (!taiLieu.equals(other.taiLieu))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DanhMucSach [taiLieu=" + taiLieu + ", chiTietSach=" + chiTietSach + "]";
	}
	
}
