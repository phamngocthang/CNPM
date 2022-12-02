package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dangky database table.
 * 
 */
@Entity
@NamedQuery(name="Dangky.findAll", query="SELECT d FROM Dangky d")
public class DangKy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idDangKy;

	private int diem;
	
	private String TrNhom;
	
	private String ThanhVien;

	public String getTrNhom() {
		return TrNhom;
	}

	public void setTrNhom(String trNhom) {
		TrNhom = trNhom;
	}

	public String getThanhVien() {
		return ThanhVien;
	}

	public void setThanhVien(String thanhVien) {
		ThanhVien = thanhVien;
	}

	private String GVPhanBien;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="GVHuongDan")
	private Account account;

	//bi-directional many-to-one association to Detai
	@ManyToOne
	@JoinColumn(name="IdDeTai")
	private DeTai detai;

	public DangKy() {
	}

	public int getIdDangKy() {
		return this.idDangKy;
	}

	public void setIdDangKy(int idDangKy) {
		this.idDangKy = idDangKy;
	}

	public int getDiem() {
		return this.diem;
	}

	public void setDiem(int diem) {
		this.diem = diem;
	}

	public String getGVPhanBien() {
		return this.GVPhanBien;
	}
	

	public void setGVPhanBien(String GVPhanBien) {
		this.GVPhanBien = GVPhanBien;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public DeTai getDetai() {
		return this.detai;
	}

	public void setDetai(DeTai detai) {
		this.detai = detai;
	}


}