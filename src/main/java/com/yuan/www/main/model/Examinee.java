package com.yuan.www.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_examinee")
public class Examinee extends UserEntity {
	
	@Column(name="student_id" ,length=11)
	private Integer studentId;
	
	@Column(name="_class",length=11)
	private Integer _class;
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer get_class() {
		return _class;
	}
	public void set_class(Integer _class) {
		this._class = _class;
	}
	
}
