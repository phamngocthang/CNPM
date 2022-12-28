package entity;

import java.io.Serializable;
import javax.persistence.*;


import java.util.List;


/**
 * The persistent class for the detai database table.
 * 
 */
@Entity
//@NamedQuery(name="Detai.findAll", query="SELECT d FROM Detai d")
public class DeTai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idDeTai;

	private String mucTieu;

	private String sanPham;

	private String tenDeTai;

	private String yeuCau;
	
	private int nienKhoa;


	//bi-directional many-to-one association to Dangky
	@OneToMany(mappedBy="detai")
	private List<DangKy> dangkies;

	//bi-directional many-to-one association to Chuyennganh
	@ManyToOne
	@JoinColumn(name="ChuyenNganh")
	private ChuyenNganh chuyennganh;

	//bi-directional many-to-one association to Loaidetai
	@ManyToOne
	@JoinColumn(name="IdLoaiDeTai")
	private LoaiDeTai loaidetai;
	
	public DeTai() {
	}

	public int getIdDeTai() {
		return this.idDeTai;
	}

	public void setIdDeTai(int idDeTai) {
		this.idDeTai = idDeTai;
	}
	
	public int getNienKhoa() {
		return this.nienKhoa;
	}

	public void setNienKhoa(int nienKhoa) {
		this.nienKhoa = nienKhoa;
	}

	public String getMucTieu() {
		return this.mucTieu;
	}

	public void setMucTieu(String mucTieu) {
		this.mucTieu = mucTieu;
	}

	public String getSanPham() {
		return this.sanPham;
	}

	public void setSanPham(String sanPham) {
		this.sanPham = sanPham;
	}

	public String getTenDeTai() {
		return this.tenDeTai;
	}

	public void setTenDeTai(String tenDeTai) {
		this.tenDeTai = tenDeTai;
	}

	public String getYeuCau() {
		return this.yeuCau;
	}

	public void setYeuCau(String yeuCau) {
		this.yeuCau = yeuCau;
	}

	public List<DangKy> getDangkies() {
		return this.dangkies;
	}

	public void setDangkies(List<DangKy> dangkies) {
		this.dangkies = dangkies;
	}

	public DangKy addDangky(DangKy dangky) {
		getDangkies().add(dangky);
		dangky.setDetai(this);

		return dangky;
	}

	public DangKy removeDangky(DangKy dangky) {
		getDangkies().remove(dangky);
		dangky.setDetai(null);

		return dangky;
	}

	public ChuyenNganh getChuyennganh() {
		return this.chuyennganh;
	}

	public void setChuyennganh(ChuyenNganh chuyennganh) {
		this.chuyennganh = chuyennganh;
	}

	public LoaiDeTai getLoaidetai() {
		return this.loaidetai;
	}

	public void setLoaidetai(LoaiDeTai loaidetai) {
		this.loaidetai = loaidetai;
	}
}