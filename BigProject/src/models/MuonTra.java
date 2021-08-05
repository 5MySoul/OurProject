package models;

import java.util.Date;

public class MuonTra {
	private String maThe;
	private TaiLieu tailieu;
	private int soLuong;
	private Date ngaymuon, ngaytra;
	public MuonTra(String maThe, TaiLieu tailieu, int soLuong, Date ngaymuon, Date ngaytra) {
		super();
		this.maThe = maThe;
		this.tailieu = tailieu;
		this.soLuong = soLuong;
		this.ngaymuon = ngaymuon;
		this.ngaytra = ngaytra;
	}
	public MuonTra() {
		super();
	}
	public String getMaThe() {
		return maThe;
	}
	public void setMaThe(String maThe) {
		this.maThe = maThe;
	}
	public TaiLieu getTailieu() {
		return tailieu;
	}
	public void setTailieu(TaiLieu tailieu) {
		this.tailieu = tailieu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Date getNgaymuon() {
		return ngaymuon;
	}
	public void setNgaymuon(Date ngaymuon) {
		this.ngaymuon = ngaymuon;
	}
	public Date getNgaytra() {
		return ngaytra;
	}
	public void setNgaytra(Date ngaytra) {
		this.ngaytra = ngaytra;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		MuonTra other = (MuonTra) obj;
		if (tailieu == null) {
			if (other.tailieu != null)
				return false;
		} else if (!tailieu.equals(other.tailieu))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MuonTra [maThe=" + maThe + ", tailieu=" + tailieu + ", soLuong=" + soLuong + ", ngaymuon=" + ngaymuon
				+ ", ngaytra=" + ngaytra + "]";
	}
	
}
