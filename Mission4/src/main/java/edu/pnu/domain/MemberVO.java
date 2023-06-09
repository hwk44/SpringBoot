package edu.pnu.domain;

import java.util.Date;

public class MemberVO {

	int id;
	String pass;
	String name;
	Date regidate;
	
	public MemberVO() {
		// 기본생성자
	}
	
	public MemberVO(int id, String pass, String name, Date residate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = residate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pass=" + pass + ", name=" + name + ", regidate=" + regidate + "]";
	}
	
	
	
	
	
}
