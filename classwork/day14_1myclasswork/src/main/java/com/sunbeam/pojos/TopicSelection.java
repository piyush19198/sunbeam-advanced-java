package com.sunbeam.pojos;

public class TopicSelection {
	private int topic;

	public TopicSelection() {
		this.topic = 0;
	}
	
	public TopicSelection(int topic) {
		this.topic = topic;
	}

	public int getTopic() {
		return topic;
	}

	public void setTopic(int topic) {
		this.topic = topic;
	}
}
