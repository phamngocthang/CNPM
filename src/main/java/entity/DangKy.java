package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dangky database table.
 * 
 */
@Entity
@NamedQuery(name="Dangky.findAll", query="SELECT d FROM Dangky d")
public class Dangky implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idDangKy;

	private int diem;

	private String GVPhanBien;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="GVHuongDan")
	private Account account;

	//bi-directional many-to-one association to Detai
	@ManyToOne
	@JoinColumn(name="IdDeTai")
	private Detai detai;

	//bi-directional many-to-one association to Nhom
	@ManyToOne
	@JoinColumn(name="IdNhom")
	private Nhom nhom;

	public Dangky() {
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

	public Detai getDetai() {
		return this.detai;
	}

	public void setDetai(Detai detai) {
		this.detai = detai;
	}

	public Nhom getNhom() {
		return this.nhom;
	}

	public void setNhom(Nhom nhom) {
		this.nhom = nhom;
	}

}