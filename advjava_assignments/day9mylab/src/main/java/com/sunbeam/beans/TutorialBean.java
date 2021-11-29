package com.sunbeam.beans;

import java.util.List;

import com.sunbeam.daos.TutorialDaoImpl;
import com.sunbeam.pojos.Tutorial;

public class TutorialBean {
	
	
	private List<Tutorial> tutorialList;

	public List<Tutorial> getTutorialList() {
		return tutorialList;
	}
	public void setTutorialList(List<Tutorial> tutorialList) {
		this.tutorialList = tutorialList;
	}
	
	public void fetchTopicTutorials() {
		try(TutorialDaoImpl dao = new TutorialDaoImpl()) {
			this.tutorialList = dao.getTutorials();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
