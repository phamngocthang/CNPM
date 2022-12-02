package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the loaidetai database table.
 * 
 */
@Entity
@NamedQuery(name="Loaidetai.findAll", query="SELECT l FROM Loaidetai l")
public class LoaiDeTai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLoaiDeTai;

	private int nienKhoa;

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

	public List<DeTai> getDetais() {
		return this.detais;
	}

	public void setDetais(List<DeTai> detais) {
		this.detais = detais;
	}

//	public DeTai addDetai(DeTai detai) {
//		getDetais().add(detai);
//		detai.setLoaidetai(this);
//
//		return detai;
//	}

//	public DeTai removeDetai(DeTai detai) {
//		getDetais().remove(detai);
//		detai.setLoaidetai(null);
//
//		return detai;
//	}

}