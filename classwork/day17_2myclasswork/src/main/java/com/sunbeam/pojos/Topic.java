package com.sunbeam.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "topics")
public class Topic {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@OneToMany(mappedBy = "topic", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) // FK field name
	private List<Tutorial> tutorialList;

	public Topic() {
		this.tutorialList = new ArrayList<Tutorial>();
	}

	public Topic(int id, String name) {
		this.id = id;
		this.name = name;
		this.tutorialList = new ArrayList<Tutorial>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Tutorial> getTutorialList() {
		return tutorialList;
	}

	public void setTutorialList(List<Tutorial> tutorialList) {
		this.tutorialList = tutorialList;
	}

	@Override
	public String toString() {
		return String.format("Topic [id=%s, name=%s]", id, name);
	}

	public void addTopic(Tutorial tut) {
		this.tutorialList.add(tut);
		tut.setTopic(this);
	}
	
}


