package models;

public class ThongTinSach {
	String matl, masach, tinhtrang, tentl, tentg, matg;
	int namxb, lanxb;
	String nhaxb;
	int sotrang;
	String khogiay;
	int gia;
	String cd;
	int soluong;
	public ThongTinSach(String matl, String masach, String tinhtrang, String tentl, String tentg, String matg,
			int namxb, int lanxb, String nhaxb, int sotrang, String khogiay, int gia, String cd, int soluong) {
		super();
		this.matl = matl;
		this.masach = masach;
		this.tinhtrang = tinhtrang;
		this.tentl = tentl;
		this.tentg = tentg;
		this.matg = matg;
		this.namxb = namxb;
		this.lanxb = lanxb;
		this.nhaxb = nhaxb;
		this.sotrang = sotrang;
		this.khogiay = khogiay;
		this.gia = gia;
		this.cd = cd;
		this.soluong = soluong;
	}
	public ThongTinSach() {
		super();
	}
	public String getMatl() {
		return matl;
	}
	public void setMatl(String matl) {
		this.matl = matl;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTinhtrang() {
		return tinhtrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	public String getTentl() {
		return tentl;
	}
	public void setTentl(String tentl) {
		this.tentl = tentl;
	}
	public String getTentg() {
		return tentg;
	}
	public void setTentg(String tentg) {
		this.tentg = tentg;
	}
	public String getMatg() {
		return matg;
	}
	public void setMatg(String matg) {
		this.matg = matg;
	}
	public int getNamxb() {
		return namxb;
	}
	public void setNamxb(int namxb) {
		this.namxb = namxb;
	}
	public int getLanxb() {
		return lanxb;
	}
	public void setLanxb(int lanxb) {
		this.lanxb = lanxb;
	}
	public String getNhaxb() {
		return nhaxb;
	}
	public void setNhaxb(String nhaxb) {
		this.nhaxb = nhaxb;
	}
	public int getSotrang() {
		return sotrang;
	}
	public void setSotrang(int sotrang) {
		this.sotrang = sotrang;
	}
	public String getKhogiay() {
		return khogiay;
	}
	public void setKhogiay(String khogiay) {
		this.khogiay = khogiay;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matl == null) ? 0 : matl.hashCode());
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
		ThongTinSach other = (ThongTinSach) obj;
		if (matl == null) {
			if (other.matl != null)
				return false;
		} else if (!matl.equals(other.matl))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return tentl ;
	}
	
}
