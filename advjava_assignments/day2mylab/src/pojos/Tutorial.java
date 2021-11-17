package pojos;

import java.sql.Date;

public class Tutorial {
	private int tut_id;
	private String name;
	private String author;
	private Date publish_date;
	private int visits;
	private int topic_id;
	private String contents;
	
	@Override
	public String toString() {
		return "Tutorial [tut_id=" + tut_id + ", name=" + name + ", author=" + author + ", publish_date=" + publish_date
				+ ", visits=" + visits + ", topic_id=" + topic_id + ", contents=" + contents + "]";
	}

	public Tutorial(int tut_id, String name, String author, Date publish_date, int visits, int topic_id,
			String contents) {
		super();
		this.tut_id = tut_id;
		this.name = name;
		this.author = author;
		this.publish_date = publish_date;
		this.visits = visits;
		this.topic_id = topic_id;
		this.contents = contents;
	}

	public Tutorial() {
		super();
	}
	
	public Tutorial(String name) {
		super();
		this.name=name;
	}

	public int getTut_id() {
		return tut_id;
	}

	public void setTut_id(int tut_id) {
		this.tut_id = tut_id;
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

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
