package models;

import java.util.Date;

public class DocGia {
	private MuonTra the;
	private Date ngayCapThe;
	private String ten, nghenghiep, phai;
	public DocGia(MuonTra the, Date ngayCapThe, String ten, String nghenghiep, String phai) {
		super();
		this.the = the;
		this.ngayCapThe = ngayCapThe;
		this.ten = ten;
		this.nghenghiep = nghenghiep;
		this.phai = phai;
	}
	public DocGia() {
		super();
	}
	public MuonTra getThe() {
		return the;
	}
	public void setThe(MuonTra the) {
		this.the = the;
	}
	public Date getNgayCapThe() {
		return ngayCapThe;
	}
	public void setNgayCapThe(Date ngayCapThe) {
		this.ngayCapThe = ngayCapThe;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getNghenghiep() {
		return nghenghiep;
	}
	public void setNghenghiep(String nghenghiep) {
		this.nghenghiep = nghenghiep;
	}
	public String getPhai() {
		return phai;
	}
	public void setPhai(String phai) {
		this.phai = phai;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((the == null) ? 0 : the.hashCode());
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
		DocGia other = (DocGia) obj;
		if (the == null) {
			if (other.the != null)
				return false;
		} else if (!the.equals(other.the))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DocGia [the=" + the + ", ten=" + ten + "]";
	}
	
}
