package models;

public class QuyenTruyCap {
	private String userName, passWord;
	private int level;
	
	public QuyenTruyCap(String userName, String passWord, int level) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.level = level;
	}
	
	public QuyenTruyCap() {
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		QuyenTruyCap other = (QuyenTruyCap) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "QuyenTruyCap [userName=" + userName + "]";
	}
	
}
