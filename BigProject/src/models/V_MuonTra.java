package models;

import java.util.Date;

public class V_MuonTra {
	private String mathe, ten, matailieu, tenTL;
	private Date ngayMuon, ngayTra;
	
	public V_MuonTra() {
		super();
	}

	public V_MuonTra(String mathe, String ten, String matailieu, String tenTL, Date ngayMuon, Date ngayTra) {
		super();
		this.mathe = mathe;
		this.ten = ten;
		this.matailieu = matailieu;
		this.tenTL = tenTL;
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
	}

	public String getMathe() {
		return mathe;
	}

	public void setMathe(String mathe) {
		this.mathe = mathe;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMatailieu() {
		return matailieu;
	}

	public void setMatailieu(String matailieu) {
		this.matailieu = matailieu;
	}

	public String getTenTL() {
		return tenTL;
	}

	public void setTenTL(String tenTL) {
		this.tenTL = tenTL;
	}

	public Date getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public Date getNgayTra() {
		return ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matailieu == null) ? 0 : matailieu.hashCode());
		result = prime * result + ((mathe == null) ? 0 : mathe.hashCode());
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
		V_MuonTra other = (V_MuonTra) obj;
		if (matailieu == null) {
			if (other.matailieu != null)
				return false;
		} else if (!matailieu.equals(other.matailieu))
			return false;
		if (mathe == null) {
			if (other.mathe != null)
				return false;
		} else if (!mathe.equals(other.mathe))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return tenTL;
	}
	
	
}
