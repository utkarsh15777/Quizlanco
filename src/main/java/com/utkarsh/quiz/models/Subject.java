package com.utkarsh.quiz.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="Subject",nullable = false)
	private String sub;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="sub_id",referencedColumnName ="id")
	private List<QuesAndAns> list;
	
	
	public Subject() {
		super();
	}

	public Subject(String sub) {
		super();
		this.sub = sub;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public List<QuesAndAns> getList() {
		return list;
	}

	public void setList(List<QuesAndAns> list) {
		this.list = list;
	}
	
	
}
