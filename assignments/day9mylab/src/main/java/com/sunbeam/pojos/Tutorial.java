package com.sunbeam.pojos;

import java.sql.Date;

public class Tutorial {
	private int id;
	private String name;
	private String author;
	private Date publishDate;
	private int visits;
	private String contents;
	private int topicId;
	private String topic;
	
	public Tutorial() {
	}

	public Tutorial(int id, String name, String author, Date publishDate, int visits, String contents, int topicId,
			String topic) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publishDate = publishDate;
		this.visits = visits;
		this.contents = contents;
		this.topicId = topicId;
		this.topic = topic;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return String.format(
				"Tutorial [id=%s, name=%s, author=%s, publishDate=%s, visits=%s, contents=%s, topicId=%s, topic=%s]",
				id, name, author, publishDate, visits, contents, topicId, topic);
	}
}
