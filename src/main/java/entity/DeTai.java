package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the detai database table.
 * 
 */
@Entity
@NamedQuery(name="Detai.findAll", query="SELECT d FROM Detai d")
public class Detai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idDeTai;

	private String mucTieu;

	private String sanPham;

	private String tenDeTai;

	private String yeuCau;

	//bi-directional many-to-one association to Dangky
	@OneToMany(mappedBy="detai")
	private List<Dangky> dangkies;

	//bi-directional many-to-one association to Chuyennganh
	@ManyToOne
	@JoinColumn(name="ChuyenNganh")
	private Chuyennganh chuyennganh;

	//bi-directional many-to-one association to Loaidetai
	@ManyToOne
	@JoinColumn(name="LoaiDeTai")
	private Loaidetai loaidetai;

	public Detai() {
	}

	public int getIdDeTai() {
		return this.idDeTai;
	}

	public void setIdDeTai(int idDeTai) {
		this.idDeTai = idDeTai;
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

	public List<Dangky> getDangkies() {
		return this.dangkies;
	}

	public void setDangkies(List<Dangky> dangkies) {
		this.dangkies = dangkies;
	}

	public Dangky addDangky(Dangky dangky) {
		getDangkies().add(dangky);
		dangky.setDetai(this);

		return dangky;
	}

	public Dangky removeDangky(Dangky dangky) {
		getDangkies().remove(dangky);
		dangky.setDetai(null);

		return dangky;
	}

	public Chuyennganh getChuyennganh() {
		return this.chuyennganh;
	}

	public void setChuyennganh(Chuyennganh chuyennganh) {
		this.chuyennganh = chuyennganh;
	}

	public Loaidetai getLoaidetai() {
		return this.loaidetai;
	}

	public void setLoaidetai(Loaidetai loaidetai) {
		this.loaidetai = loaidetai;
	}

}