package models;

import java.util.ArrayList;

public class TacGia {
	private String maTacGia, tenTacGia;
	private int namsinh;
	private ArrayList<ChiTietSach> chiTietSachs = new ArrayList<ChiTietSach>();
	public TacGia(String maTacGia, String tenTacGia, int namsinh) {
		super();
		this.maTacGia = maTacGia;
		this.tenTacGia = tenTacGia;
		this.namsinh = namsinh;
	}
	public TacGia() {
		super();
	}
	
	public ArrayList<ChiTietSach> getChiTietSachs() {
		return chiTietSachs;
	}
	public void setChiTietSachs(ArrayList<ChiTietSach> chiTietSachs) {
		this.chiTietSachs = chiTietSachs;
	}
	public String getMaTacGia() {
		return maTacGia;
	}
	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}
	public String getTenTacGia() {
		return tenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		this.tenTacGia = tenTacGia;
	}
	public int getNamsinh() {
		return namsinh;
	}
	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTacGia == null) ? 0 : maTacGia.hashCode());
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
		TacGia other = (TacGia) obj;
		if (maTacGia == null) {
			if (other.maTacGia != null)
				return false;
		} else if (!maTacGia.equals(other.maTacGia))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return tenTacGia;
	}
	

}
