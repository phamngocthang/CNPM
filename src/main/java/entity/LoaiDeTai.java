package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the loaidetai database table.
 * 
 */
@Entity
@NamedQuery(name="Loaidetai.findAll", query="SELECT l FROM Loaidetai l")
public class Loaidetai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLoaiDeTai;

	private int nienKhoa;

	private String tenLoaiDeTai;

	//bi-directional many-to-one association to Detai
	@OneToMany(mappedBy="loaidetai")
	private List<Detai> detais;

	public Loaidetai() {
	}

	public int getIdLoaiDeTai() {
		return this.idLoaiDeTai;
	}

	public void setIdLoaiDeTai(int idLoaiDeTai) {
		this.idLoaiDeTai = idLoaiDeTai;
	}

	public int getNienKhoa() {
		return this.nienKhoa;
	}

	public void setNienKhoa(int nienKhoa) {
		this.nienKhoa = nienKhoa;
	}

	public String getTenLoaiDeTai() {
		return this.tenLoaiDeTai;
	}

	public void setTenLoaiDeTai(String tenLoaiDeTai) {
		this.tenLoaiDeTai = tenLoaiDeTai;
	}

	public List<Detai> getDetais() {
		return this.detais;
	}

	public void setDetais(List<Detai> detais) {
		this.detais = detais;
	}

	public Detai addDetai(Detai detai) {
		getDetais().add(detai);
		detai.setLoaidetai(this);

		return detai;
	}

	public Detai removeDetai(Detai detai) {
		getDetais().remove(detai);
		detai.setLoaidetai(null);

		return detai;
	}

}