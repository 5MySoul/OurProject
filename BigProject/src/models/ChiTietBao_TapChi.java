package models;

public class ChiTietBao_TapChi {
	private TaiLieu tailieu;
	private int namPhatHanh;
	public ChiTietBao_TapChi(TaiLieu tailieu, int namPhatHanh) {
		super();
		this.tailieu = tailieu;
		this.namPhatHanh = namPhatHanh;
	}
	public ChiTietBao_TapChi() {
		super();
	}
	public TaiLieu getTailieu() {
		return tailieu;
	}
	public void setTailieu(TaiLieu tailieu) {
		this.tailieu = tailieu;
	}
	public int getNamPhatHanh() {
		return namPhatHanh;
	}
	public void setNamPhatHanh(int namPhatHanh) {
		this.namPhatHanh = namPhatHanh;
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
		ChiTietBao_TapChi other = (ChiTietBao_TapChi) obj;
		if (tailieu == null) {
			if (other.tailieu != null)
				return false;
		} else if (!tailieu.equals(other.tailieu))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ChiTietBao_TapChi [tailieu=" + tailieu + ", namPhatHanh=" + namPhatHanh + "]";
	}
	
}
