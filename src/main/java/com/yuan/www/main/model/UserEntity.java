package com.yuan.www.main.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class UserEntity {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	protected Integer id;
	
	@Column(name="sex",length=2)
	protected String sex;
	
	@Column(name="nationality",length=20)
	protected String nationality;
	
	@Column(name="height")
	protected Integer height;
	
	@Column(name="weight")
	protected Double weight;
	
	@Column(name="school",length=20)
	protected String school;
	
	@Column(name="tel",length=11)
	protected String tel;
	
	@Column(name="avater",length=100)
	protected String avater;
	
	@Column(name="name",length=10,nullable=true)
	protected String name;
	
	@Column(name="password",length=20)
	private String password;
	
	@Column(name="login_time")
	protected Date loginTime;
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getTel() {
		return tel;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
	public String getAvater() {
		return avater;
	}

	public void setAvater(String avater) {
		this.avater = avater;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
