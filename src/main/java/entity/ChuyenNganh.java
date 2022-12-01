package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the chuyennganh database table.
 * 
 */
@Entity
@NamedQuery(name="Chuyennganh.findAll", query="SELECT c FROM Chuyennganh c")
public class Chuyennganh implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idChuyenNganh;

	private String tenChuyenNganh;

	//bi-directional many-to-one association to Detai
	@OneToMany(mappedBy="chuyennganh")
	private List<Detai> detais;

	//bi-directional many-to-one association to Inforaccount
	@OneToMany(mappedBy="chuyennganh")
	private List<Inforaccount> inforaccounts;

	public Chuyennganh() {
	}

	public int getIdChuyenNganh() {
		return this.idChuyenNganh;
	}

	public void setIdChuyenNganh(int idChuyenNganh) {
		this.idChuyenNganh = idChuyenNganh;
	}

	public String getTenChuyenNganh() {
		return this.tenChuyenNganh;
	}

	public void setTenChuyenNganh(String tenChuyenNganh) {
		this.tenChuyenNganh = tenChuyenNganh;
	}

	public List<Detai> getDetais() {
		return this.detais;
	}

	public void setDetais(List<Detai> detais) {
		this.detais = detais;
	}

	public Detai addDetai(Detai detai) {
		getDetais().add(detai);
		detai.setChuyennganh(this);

		return detai;
	}

	public Detai removeDetai(Detai detai) {
		getDetais().remove(detai);
		detai.setChuyennganh(null);

		return detai;
	}

	public List<Inforaccount> getInforaccounts() {
		return this.inforaccounts;
	}

	public void setInforaccounts(List<Inforaccount> inforaccounts) {
		this.inforaccounts = inforaccounts;
	}

	public Inforaccount addInforaccount(Inforaccount inforaccount) {
		getInforaccounts().add(inforaccount);
		inforaccount.setChuyennganh(this);

		return inforaccount;
	}

	public Inforaccount removeInforaccount(Inforaccount inforaccount) {
		getInforaccounts().remove(inforaccount);
		inforaccount.setChuyennganh(null);

		return inforaccount;
	}

}