package entity;

public class DangKy {
	private int idDangKy;
	private int idDeTai;
	private String tenDeTai;
	private int idNhom;
	private int slThanhVien;
	private String tenChuyenNganh;
	private String gvHuongDan;
	private String gvPhanBien;
	private int diem;
	public int getIdDangKy() {
		return idDangKy;
	}
	public void setIdDangKy(int idDangKy) {
		this.idDangKy = idDangKy;
	}
	public String getTenDeTai() {
		return tenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		this.tenDeTai = tenDeTai;
	}
	public int getSlThanhVien() {
		return slThanhVien;
	}
	public void setSlThanhVien(int slThanhVien) {
		this.slThanhVien = slThanhVien;
	}
	public String getTenChuyenNganh() {
		return tenChuyenNganh;
	}
	public void setTenChuyenNganh(String tenChuyenNganh) {
		this.tenChuyenNganh = tenChuyenNganh;
	}
	public DangKy(int idDangKy, String tenDeTai, int slThanhVien, String tenChuyenNganh, String gvHuongDan) {
		super();
		this.idDangKy = idDangKy;
		this.tenDeTai = tenDeTai;
		this.slThanhVien = slThanhVien;
		this.tenChuyenNganh = tenChuyenNganh;
		this.gvHuongDan = gvHuongDan;
	}
	public int getIdDeTai() {
		return idDeTai;
	}
	public void setIdDeTai(int idDeTai) {
		this.idDeTai = idDeTai;
	}
	public int getIdNhom() {
		return idNhom;
	}
	public void setIdNhom(int idNhom) {
		this.idNhom = idNhom;
	}
	public String getGvHuongDan() {
		return gvHuongDan;
	}
	public void setGvHuongDan(String gvHuongDan) {
		this.gvHuongDan = gvHuongDan;
	}
	public String getGvPhanBien() {
		return gvPhanBien;
	}
	public void setGvPhanBien(String gvPhanBien) {
		this.gvPhanBien = gvPhanBien;
	}
	public int getDiem() {
		return diem;
	}
	public void setDiem(int diem) {
		this.diem = diem;
	}

	public DangKy() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DangKy [idDangKy=" + idDangKy + ", tenDeTai=" + tenDeTai + ", slThanhVien=" + slThanhVien
				+ ", tenChuyenNganh=" + tenChuyenNganh + ", gvHuongDan=" + gvHuongDan + "]";
	}
	
	
}
