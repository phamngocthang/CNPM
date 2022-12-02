package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nhom database table.
 * 
 */
@Entity
@NamedQuery(name="Nhom.findAll", query="SELECT n FROM Nhom n")
public class Nhom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idNhom;

	//bi-directional many-to-one association to Dangky
	@OneToMany(mappedBy="nhom")
	private List<DangKy> dangkies;

	//bi-directional many-to-one association to Inforaccount
	@ManyToOne
	@JoinColumn(name="TrNhom")
	private Inforaccount inforaccount1;

	//bi-directional many-to-one association to Inforaccount
	@ManyToOne
	@JoinColumn(name="ThanhVien")
	private Inforaccount inforaccount2;

	public Nhom() {
	}

	public int getIdNhom() {
		return this.idNhom;
	}

	public void setIdNhom(int idNhom) {
		this.idNhom = idNhom;
	}

	public List<DangKy> getDangkies() {
		return this.dangkies;
	}

	public void setDangkies(List<DangKy> dangkies) {
		this.dangkies = dangkies;
	}

//	public DangKy addDangky(DangKy dangky) {
//		getDangkies().add(dangky);
//		dangky.setNhom(this);
//
//		return dangky;
//	}

//	public DangKy removeDangky(DangKy dangky) {
//		getDangkies().remove(dangky);
//		dangky.setNhom(null);
//
//		return dangky;
//	}

	public Inforaccount getInforaccount1() {
		return this.inforaccount1;
	}

	public void setInforaccount1(Inforaccount inforaccount1) {
		this.inforaccount1 = inforaccount1;
	}

	public Inforaccount getInforaccount2() {
		return this.inforaccount2;
	}

	public void setInforaccount2(Inforaccount inforaccount2) {
		this.inforaccount2 = inforaccount2;
	}

}