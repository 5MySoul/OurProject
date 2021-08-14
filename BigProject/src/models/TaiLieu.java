package models;

import java.util.ArrayList;

public class TaiLieu {
	private String maTL, tenTL;
	private LoaiTaiLieu loaiTaiLieu;
	private ArrayList<KyXuatBan> kyXuatBans = new ArrayList<KyXuatBan>();

	public ArrayList<KyXuatBan> getKyXuatBans() {
		return kyXuatBans;
	}

	public void setKyXuatBans(ArrayList<KyXuatBan> kyXuatBans) {
		this.kyXuatBans = kyXuatBans;
	}

	public void add(KyXuatBan kyXuatBan) {
		kyXuatBans.add(kyXuatBan);
	}

	public void remove(KyXuatBan kyXuatBan) {
		kyXuatBans.remove(kyXuatBan);
	}

	public TaiLieu(String maTL, String tenTL, LoaiTaiLieu loaiTaiLieu) {
		super();
		this.maTL = maTL;
		this.tenTL = tenTL;
		this.loaiTaiLieu = loaiTaiLieu;
	}

	public TaiLieu() {
		super();
	}

	public String getMaTL() {
		return maTL;
	}

	public void setMaTL(String maTL) {
		this.maTL = maTL;
	}

	public String getTenTL() {
		return tenTL;
	}

	public void setTenTL(String tenTL) {
		this.tenTL = tenTL;
	}

	public LoaiTaiLieu getLoaiTaiLieu() {
		return loaiTaiLieu;
	}

	public void setLoaiTaiLieu(LoaiTaiLieu loaiTaiLieu) {
		this.loaiTaiLieu = loaiTaiLieu;
	}

	@Override
	public String toString() {
		return "TaiLieu [tenTL=" + tenTL + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTL == null) ? 0 : maTL.hashCode());
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
		TaiLieu other = (TaiLieu) obj;
		if (maTL == null) {
			if (other.maTL != null)
				return false;
		} else if (!maTL.equals(other.maTL))
			return false;
		return true;
	}

}
