package entity;

public class ChuyenNganh {
	private int idChuyenNganh;
	private String tenChuyenNganh;
	public int getIdChuyenNganh() {
		return idChuyenNganh;
	}
	public void setIdChuyenNganh(int idChuyenNganh) {
		this.idChuyenNganh = idChuyenNganh;
	}
	public String getTenChuyenNganh() {
		return tenChuyenNganh;
	}
	public void setTenChuyenNganh(String tenChuyenNganh) {
		this.tenChuyenNganh = tenChuyenNganh;
	}
	public ChuyenNganh(int idChuyenNganh, String tenChuyenNganh) {
		super();
		this.idChuyenNganh = idChuyenNganh;
		this.tenChuyenNganh = tenChuyenNganh;
	}
	public ChuyenNganh() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChuyenNganh [idChuyenNganh=" + idChuyenNganh + ", tenChuyenNganh=" + tenChuyenNganh + "]";
	}
}
