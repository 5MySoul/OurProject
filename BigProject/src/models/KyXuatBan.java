package models;

public class KyXuatBan {
	private TaiLieu tailieu;
	private int kyXB, soLuongNhap, soLuongTon;
	public KyXuatBan(TaiLieu tailieu, int kyXB, int soLuongNhap, int soLuongTon) {
		super();
		this.tailieu = tailieu;
		this.kyXB = kyXB;
		this.soLuongNhap = soLuongNhap;
		this.soLuongTon = soLuongTon;
	}
	public KyXuatBan() {
		super();
	}
	public TaiLieu getTailieu() {
		return tailieu;
	}
	public void setTailieu(TaiLieu tailieu) {
		this.tailieu = tailieu;
	}
	public int getKyXB() {
		return kyXB;
	}
	public void setKyXB(int kyXB) {
		this.kyXB = kyXB;
	}
	public int getSoLuongNhap() {
		return soLuongNhap;
	}
	public void setSoLuongNhap(int soLuongNhap) {
		this.soLuongNhap = soLuongNhap;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + kyXB;
		result = prime * result + ((tailieu == null) ? 0 : tailieu.hashCode());
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
		KyXuatBan other = (KyXuatBan) obj;
		if (kyXB != other.kyXB)
			return false;
		if (tailieu == null) {
			if (other.tailieu != null)
				return false;
		} else if (!tailieu.equals(other.tailieu))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "KyXuatBan [tailieu=" + tailieu + ", kyXB=" + kyXB + ", soLuongNhap=" + soLuongNhap + ", soLuongTon="
				+ soLuongTon + "]";
	}
	
	
}
