package com.sunbeam.beans;

import com.sunbeam.daos.TutorialDaoImpl;
import com.sunbeam.pojos.Tutorial;

public class DetailsBean {
	private int tut_id;
	private Tutorial tutorial;
	public int getTut_id() {
		return tut_id;
	}
	public void setTut_id(int tut_id) {
		this.tut_id = tut_id;
	}
	public Tutorial getTutorial() {
		return tutorial;
	}
	public void setTutorial(Tutorial tutorial) {
		this.tutorial = tutorial;
	}
	
	 public Tutorial fetchTutorialDetails() {
		 try(TutorialDaoImpl tutDao = new TutorialDaoImpl()){
			tutorial = tutDao.getTutorial(tut_id);
		 }catch (Exception e) {
				e.printStackTrace();
			}
		return tutorial;
	 }
	 
	 public void updateVisits() {
		 try(TutorialDaoImpl tutDao = new TutorialDaoImpl()){
			 tutDao.incrementTutorialVisits(tut_id);
		 }catch (Exception e) {
				e.printStackTrace();
			}
	 }
}
