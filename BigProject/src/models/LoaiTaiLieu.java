package models;

import java.util.ArrayList;

public class LoaiTaiLieu {
	private String maLoaiTL, tenLoaiTL;
	private ArrayList<TaiLieu> taiLieus = new ArrayList<TaiLieu>();

	public LoaiTaiLieu(String maLoaiTL, String tenLoaiTL) {
		super();
		this.maLoaiTL = maLoaiTL;
		this.tenLoaiTL = tenLoaiTL;
	}

	public LoaiTaiLieu() {
		super();
	}
	//Thêm 1 tailieu vào loaitailieu
	public void add (TaiLieu tailieu){
		taiLieus.add(tailieu);
	}
	//Bỏ 1 tailieu vào loaitailieu
	public void remove (TaiLieu tailieu){
		taiLieus.remove(tailieu);
	}
	public ArrayList<TaiLieu> getTaiLieus() {
		return taiLieus;
	}

	public void setTaiLieus(ArrayList<TaiLieu> taiLieus) {
		this.taiLieus = taiLieus;
	}

	public String getMaLoaiTL() {
		return maLoaiTL;
	}

	public void setMaLoaiTL(String maLoaiTL) {
		this.maLoaiTL = maLoaiTL;
	}

	public String getTenLoaiTL() {
		return tenLoaiTL;
	}

	public void setTenLoaiTL(String tenLoaiTL) {
		this.tenLoaiTL = tenLoaiTL;
	}

	@Override
	public String toString() {
		return  tenLoaiTL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiTL == null) ? 0 : maLoaiTL.hashCode());
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
		LoaiTaiLieu other = (LoaiTaiLieu) obj;
		if (maLoaiTL == null) {
			if (other.maLoaiTL != null)
				return false;
		} else if (!maLoaiTL.equals(other.maLoaiTL))
			return false;
		return true;
	}
	
}
