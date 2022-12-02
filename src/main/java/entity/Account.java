package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
//@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private int loaiTaiKhoan;

	private String password;

	//bi-directional many-to-one association to Dangky
	@OneToMany(mappedBy="account")
	private List<DangKy> dangkies;

	//bi-directional one-to-one association to Inforaccount
	@OneToOne(mappedBy="account")
	private Inforaccount inforaccount;

	public Account() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getLoaiTaiKhoan() {
		return this.loaiTaiKhoan;
	}

	public void setLoaiTaiKhoan(int loaiTaiKhoan) {
		this.loaiTaiKhoan = loaiTaiKhoan;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<DangKy> getDangkies() {
		return this.dangkies;
	}

	public void setDangkies(List<DangKy> dangkies) {
		this.dangkies = dangkies;
	}

	public DangKy addDangky(DangKy dangky) {
		getDangkies().add(dangky);
		dangky.setAccount(this);

		return dangky;
	}

	public DangKy removeDangky(DangKy dangky) {
		getDangkies().remove(dangky);
		dangky.setAccount(null);

		return dangky;
	}

	public Inforaccount getInforaccount() {
		return this.inforaccount;
	}

	public void setInforaccount(Inforaccount inforaccount) {
		this.inforaccount = inforaccount;
	}

}