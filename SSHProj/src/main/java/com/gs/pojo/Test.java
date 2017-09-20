package com.gs.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="t_test")
public class Test {
	@Id
	@GenericGenerator(name="nativename",strategy="uuid")
	@GeneratedValue(generator="nativename")
	@Column(name="id")
	private String id;
	@Column(name="name")
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
