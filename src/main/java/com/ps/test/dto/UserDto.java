package com.ps.test.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

public class UserDto {
	
	@Id
	@GenericGenerator(name = "incr", strategy = "increment")
	@GeneratedValue(generator = "incr")
	@Column(name="USER_ID")
	private int userid;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="PASSWORD")
	private int Active=0;
	
	/*@OneToOne(cascade = CascadeType.ALL,fetch =FetchType.EAGER,mappedBy = "loginInfo")
	@JsonIgnore
	private RegisterDTO registerdto;*/

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return Active;
	}

	public void setActive(int active) {
		Active = active;
	}

	/*public RegisterDTO getRegisterdto() {
		return registerdto;
	}

	public void setRegisterdto(RegisterDTO registerdto) {
		this.registerdto = registerdto;
	}
*/
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
}
