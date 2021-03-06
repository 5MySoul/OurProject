package models;

public class ChiTietBao_TapChi {
	private String matl;
	private int namPhatHanh;
	private int kyxb;
	public ChiTietBao_TapChi(String matl, int namPhatHanh, int kyxb) {
		super();
		this.matl = matl;
		this.namPhatHanh = namPhatHanh;
		this.kyxb = kyxb;
	}
	public ChiTietBao_TapChi() {
		super();
	}
	public String getMatl() {
		return matl;
	}
	public void setMatl(String matl) {
		this.matl = matl;
	}
	public int getNamPhatHanh() {
		return namPhatHanh;
	}
	public void setNamPhatHanh(int namPhatHanh) {
		this.namPhatHanh = namPhatHanh;
	}
	public int getKyxb() {
		return kyxb;
	}
	public void setKyxb(int kyxb) {
		this.kyxb = kyxb;
	}
	@Override
	public String toString() {
		return "ChiTietBao_TapChi [matl=" + matl + ", namPhatHanh=" + namPhatHanh + ", kyxb=" + kyxb + "]";
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
		ChiTietBao_TapChi other = (ChiTietBao_TapChi) obj;
		if (matl == null) {
			if (other.matl != null)
				return false;
		} else if (!matl.equals(other.matl))
			return false;
		return true;
	}
	
	
	
}
