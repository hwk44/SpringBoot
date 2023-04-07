package edu.pnu.domain;

import javax.persistence.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "MEMBERtest")
public class MemberTest {
	
@Id
@Column(name = "MEMBER_ID")
private String id;
private String password;
private String name;
private String role;

}
