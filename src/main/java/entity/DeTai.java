package entity;

public class DeTai {
	private int idDeTai;
	private String tenDeTai;
	private int loaiDeTai;
	private int chuyenNganh;
	private String mucTieu;
	private String yeuCau;
	private String sanPham;
	public int getIdDeTai() {
		return idDeTai;
	}
	public void setIdDeTai(int idDeTai) {
		this.idDeTai = idDeTai;
	}
	public String getTenDeTai() {
		return tenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		this.tenDeTai = tenDeTai;
	}
	public int getLoaiDeTai() {
		return loaiDeTai;
	}
	public void setLoaiDeTai(int loaiDeTai) {
		this.loaiDeTai = loaiDeTai;
	}
	public int getChuyenNganh() {
		return chuyenNganh;
	}
	public void setChuyenNganh(int chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}
	public String getMucTieu() {
		return mucTieu;
	}
	public void setMucTieu(String mucTieu) {
		this.mucTieu = mucTieu;
	}
	public String getYeuCau() {
		return yeuCau;
	}
	public void setYeuCau(String yeuCau) {
		this.yeuCau = yeuCau;
	}
	public String getSanPham() {
		return sanPham;
	}
	public void setSanPham(String sanPham) {
		this.sanPham = sanPham;
	}
	public DeTai(int idDeTai, String tenDeTai, int loaiDeTai, int chuyenNganh, String mucTieu, String yeuCau,
			String sanPham) {
		super();
		this.idDeTai = idDeTai;
		this.tenDeTai = tenDeTai;
		this.loaiDeTai = loaiDeTai;
		this.chuyenNganh = chuyenNganh;
		this.mucTieu = mucTieu;
		this.yeuCau = yeuCau;
		this.sanPham = sanPham;
	}
	public DeTai() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DeTai [idDeTai=" + idDeTai + ", tenDeTai=" + tenDeTai + ", loaiDeTai=" + loaiDeTai + ", chuyenNganh="
				+ chuyenNganh + ", mucTieu=" + mucTieu + ", yeuCau=" + yeuCau + ", sanPham=" + sanPham + "]";
	}
	
	
}
