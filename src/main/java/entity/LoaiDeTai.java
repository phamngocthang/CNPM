package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the loaidetai database table.
 * 
 */
@Entity
@NamedQuery(name="LoaiDeTai.findAll", query="SELECT l FROM LoaiDeTai l")
public class LoaiDeTai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLoaiDeTai;

	@Temporal(TemporalType.DATE)
	private Date ngayBatDau;

	@Temporal(TemporalType.DATE)
	private Date ngayKetThuc;

	private String tenLoaiDeTai;

	//bi-directional many-to-one association to Detai
	@OneToMany(mappedBy="loaidetai")
	private List<DeTai> detais;

	public LoaiDeTai() {
	}

	public int getIdLoaiDeTai() {
		return this.idLoaiDeTai;
	}

	public void setIdLoaiDeTai(int idLoaiDeTai) {
		this.idLoaiDeTai = idLoaiDeTai;
	}

	public Date getNgayBatDau() {
		return this.ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return this.ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public String getTenLoaiDeTai() {
		return this.tenLoaiDeTai;
	}

	public void setTenLoaiDeTai(String tenLoaiDeTai) {
		this.tenLoaiDeTai = tenLoaiDeTai;
	}

	public List<DeTai> getDetais() {
		return this.detais;
	}

	public void setDetais(List<DeTai> detais) {
		this.detais = detais;
	}

	public DeTai addDetai(DeTai detai) {
		getDetais().add(detai);
		detai.setLoaidetai(this);

		return detai;
	}

	public DeTai removeDetai(DeTai detai) {
		getDetais().remove(detai);
		detai.setLoaidetai(null);

		return detai;
	}

}