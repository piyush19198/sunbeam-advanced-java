package pojos;

import java.sql.Date;

public class Tutorial {
	//id | name        | author | publish_date | visits | contents                                  | topic_id
	private int tutorialId;//PK
	private String tutorialName;
	private String author;
	private Date publishDate;
	private int visits;
	private String contents;
	private int topicId;//FK ---> PK of the topics table (topicId)
	public Tutorial() {
		// TODO Auto-generated constructor stub
	}
	
	public Tutorial(int tutorialId, String tutorialName, String author, Date publishDate, int visits, String contents,int topicId) {
		super();
		this.tutorialId = tutorialId;
		this.tutorialName = tutorialName;
		this.author = author;
		this.publishDate = publishDate;
		this.visits = visits;
		this.topicId = topicId;
		this.contents=contents;
	}
	

	

	public int getTutorialId() {
		return tutorialId;
	}
	public void setTutorialId(int tutorialId) {
		this.tutorialId = tutorialId;
	}
	public String getTutorialName() {
		return tutorialName;
	}
	public void setTutorialName(String tutorialName) {
		this.tutorialName = tutorialName;
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
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Tutorial [tutorialId=" + tutorialId + ", tutorialName=" + tutorialName + ", author=" + author
				+ ", publishDate=" + publishDate + ", visits=" + visits + ", topicId=" + topicId + "]";
	}
	
	

}
