package com.safetouch.dal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "relative")
public class Relative {

	@Id
	@GeneratedValue(generator = "RELATIVE_SEQUENCE", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "human_id", referencedColumnName = "id")
	private User human;

	@Column(name = "name")
	private String name;

	@Column(name = "mobile")
	private String mobile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getHuman() {
		return human;
	}

	public void setHuman(User human) {
		this.human = human;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
