package models;

public class ThongTinBao_TapChi {
	String matl, tentl;
	int namph, kyxb;
	public ThongTinBao_TapChi(String matl, String tentl, int namph, int kyxb) {
		super();
		this.matl = matl;
		this.tentl = tentl;
		this.namph = namph;
		this.kyxb = kyxb;
	}
	public ThongTinBao_TapChi() {
		super();
	}
	public String getMatl() {
		return matl;
	}
	public void setMatl(String matl) {
		this.matl = matl;
	}
	public String getTentl() {
		return tentl;
	}
	public void setTentl(String tentl) {
		this.tentl = tentl;
	}
	public int getNamph() {
		return namph;
	}
	public void setNamph(int namph) {
		this.namph = namph;
	}
	public int getKyxb() {
		return kyxb;
	}
	public void setKyxb(int kyxb) {
		this.kyxb = kyxb;
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
		ThongTinBao_TapChi other = (ThongTinBao_TapChi) obj;
		if (matl == null) {
			if (other.matl != null)
				return false;
		} else if (!matl.equals(other.matl))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return  tentl;
	}
	
}
