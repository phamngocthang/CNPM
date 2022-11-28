package entity;

public class LoaiDeTai {
	private int idLoaiDeTai;
	private String tenLoaiDeTai;
	private int nienKhoa;
	public int getIdLoaiDeTai() {
		return idLoaiDeTai;
	}
	public void setIdLoaiDeTai(int idLoaiDeTai) {
		this.idLoaiDeTai = idLoaiDeTai;
	}
	public String getTenLoaiDeTai() {
		return tenLoaiDeTai;
	}
	public void setTenLoaiDeTai(String tenLoaiDeTai) {
		this.tenLoaiDeTai = tenLoaiDeTai;
	}
	public int getNienKhoa() {
		return nienKhoa;
	}
	public void setNienKhoa(int nienKhoa) {
		this.nienKhoa = nienKhoa;
	}
	@Override
	public String toString() {
		return "LoaiDeTai [idLoaiDeTai=" + idLoaiDeTai + ", tenLoaiDeTai=" + tenLoaiDeTai + ", nienKhoa=" + nienKhoa
				+ "]";
	}
	public LoaiDeTai(int idLoaiDeTai, String tenLoaiDeTai, int nienKhoa) {
		super();
		this.idLoaiDeTai = idLoaiDeTai;
		this.tenLoaiDeTai = tenLoaiDeTai;
		this.nienKhoa = nienKhoa;
	}
	public LoaiDeTai() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
