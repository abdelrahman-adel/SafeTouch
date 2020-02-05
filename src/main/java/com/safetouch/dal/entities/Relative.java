package com.safetouch.dal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "relative")
public class Relative {

	@Id
	private long id;

	@ManyToOne
	@JoinColumn(name = "human_id")
	private Human human;

	@Column(name = "mobile")
	private String mobile;

}
