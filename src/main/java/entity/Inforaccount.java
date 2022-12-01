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



}