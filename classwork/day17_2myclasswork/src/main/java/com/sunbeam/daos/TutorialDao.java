package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.pojos.Tutorial;

public interface TutorialDao extends JpaRepository<Tutorial, Integer> {
	List<Tutorial> findByTopicId(int id); // FROM Tutorial t WHERE t.topic.id = ?
	
	@Modifying
	@Query("UPDATE Tutorial t SET t.visits = t.visits + 1 WHERE t.id = ?1")
	int incrementTutorialVisitCount(int tutorialId);
	
	// SQL: SELECT tut.name, top.name FROM tutorials tut INNER JOIN topics top ON tut.topic_id = top.id 
	
	@Query("SELECT tut.name, top.name FROM Tutorial tut INNER JOIN tut.topic top") // explicit join -- with JOIN keyword -- inner/outer 
	public List<Object[]> findAllTutorialNameTopicName1();

	@Query("SELECT tut.name, tut.topic.name FROM Tutorial tut") // implicit join -- without JOIN keyword -- cross join + where
	public List<Object[]> findAllTutorialNameTopicName2();
	
	@Query("SELECT tut.name, top.name FROM Tutorial tut, Topic top WHERE tut.topic.id = top.id") // old SQL style join
	public List<Object[]> findAllTutorialNameTopicName3();
	
	@Query(value = "SELECT DISTINCT name FROM tutorials", nativeQuery = true)
	public List<String> findAllTutorialName();
	
	/*	// Hibernate Internals
		String sql = "SELECT DISTINCT name FROM tutorials";
		NativeQuery q = session.createNativeQuery(sql);
		return q.getResultList();
	*/

}









