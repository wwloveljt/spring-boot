package com.zhanhongit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "Person.withPatriarch_telQuery", query = "select p from Person p where p.patriarch_tel=?1")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prooduct_id_seq")
	@SequenceGenerator(name = "prooduct_id_seq", sequenceName = "hibernate_sequence", allocationSize = 1)
	private Long id;
	private String city;
	private String area;
	private String school;
	private String grade;
	private String bj;
	private String name;
	private String teacher;
	private String teacher_tel;
	private String patriarch;
	private String patriarch_tel;
	private String zkzh;
	private Boolean state;
	private String kc;
	private String zs;
	private String kssj;
	private String kd;

	public String getKd() {
		return kd;
	}

	public void setKd(String kd) {
		this.kd = kd;
	}

	public Person() {

	}
	
	public Person(Long id, String city, String area, String school, String grade, String bj, String name,
			String teacher, String teacher_tel, String patriarch, String patriarch_tel, String zkzh, Boolean state,
			String kc, String zs, String kssj, String kd) {
		super();
		this.id = id;
		this.city = city;
		this.area = area;
		this.school = school;
		this.grade = grade;
		this.bj = bj;
		this.name = name;
		this.teacher = teacher;
		this.teacher_tel = teacher_tel;
		this.patriarch = patriarch;
		this.patriarch_tel = patriarch_tel;
		this.zkzh = zkzh;
		this.state = state;
		this.kc = kc;
		this.zs = zs;
		this.kssj = kssj;
		this.kd = kd;
	}

	public String getArea() {
		return area;
	}

	public String getBj() {
		return bj;
	}

	public String getCity() {
		return city;
	}

	public String getGrade() {
		return grade;
	}

	public Long getId() {
		return id;
	}

	public String getKc() {
		return kc;
	}

	
	public String getKssj() {
		return kssj;
	}

	public String getName() {
		return name;
	}

	public String getPatriarch() {
		return patriarch;
	}

	public String getPatriarch_tel() {
		return patriarch_tel;
	}

	public String getSchool() {
		return school;
	}

	public Boolean getState() {
		return state;
	}

	public String getTeacher() {
		return teacher;
	}

	public String getTeacher_tel() {
		return teacher_tel;
	}

	public String getZkzh() {
		return zkzh;
	}

	public String getZs() {
		return zs;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setBj(String bj) {
		this.bj = bj;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setKc(String kc) {
		this.kc = kc;
	}

	public void setKssj(String kssj) {
		this.kssj = kssj;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPatriarch(String patriarch) {
		this.patriarch = patriarch;
	}

	public void setPatriarch_tel(String patriarch_tel) {
		this.patriarch_tel = patriarch_tel;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public void setTeacher_tel(String teacher_tel) {
		this.teacher_tel = teacher_tel;
	}

	public void setZkzh(String zkzh) {
		this.zkzh = zkzh;
	}

	public void setZs(String zs) {
		this.zs = zs;
	}

}
