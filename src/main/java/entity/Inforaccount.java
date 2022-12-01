package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the inforaccount database table.
 * 
 */
@Entity
@NamedQuery(name="Inforaccount.findAll", query="SELECT i FROM Inforaccount i")
public class Inforaccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String userName;

	private String address;

	private String email;

	private String fullName;

	private String phonenumber;

	//bi-directional one-to-one association to Account
	@OneToOne
	@JoinColumn(name="UserName")
	private Account account;

	//bi-directional many-to-one association to Chuyennganh
	@ManyToOne
	@JoinColumn(name="ChuyenNganh")
	private Chuyennganh chuyennganh;

	//bi-directional many-to-one association to Nhom
	@OneToMany(mappedBy="inforaccount1")
	private List<Nhom> nhoms1;

	//bi-directional many-to-one association to Nhom
	@OneToMany(mappedBy="inforaccount2")
	private List<Nhom> nhoms2;

	public Inforaccount() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Chuyennganh getChuyennganh() {
		return this.chuyennganh;
	}

	public void setChuyennganh(Chuyennganh chuyennganh) {
		this.chuyennganh = chuyennganh;
	}

	public List<Nhom> getNhoms1() {
		return this.nhoms1;
	}

	public void setNhoms1(List<Nhom> nhoms1) {
		this.nhoms1 = nhoms1;
	}

	public Nhom addNhoms1(Nhom nhoms1) {
		getNhoms1().add(nhoms1);
		nhoms1.setInforaccount1(this);

		return nhoms1;
	}

	public Nhom removeNhoms1(Nhom nhoms1) {
		getNhoms1().remove(nhoms1);
		nhoms1.setInforaccount1(null);

		return nhoms1;
	}

	public List<Nhom> getNhoms2() {
		return this.nhoms2;
	}

	public void setNhoms2(List<Nhom> nhoms2) {
		this.nhoms2 = nhoms2;
	}

	public Nhom addNhoms2(Nhom nhoms2) {
		getNhoms2().add(nhoms2);
		nhoms2.setInforaccount2(this);

		return nhoms2;
	}

	public Nhom removeNhoms2(Nhom nhoms2) {
		getNhoms2().remove(nhoms2);
		nhoms2.setInforaccount2(null);

		return nhoms2;
	}

}