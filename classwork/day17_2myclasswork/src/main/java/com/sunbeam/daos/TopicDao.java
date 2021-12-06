package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.pojos.Topic;

public interface TopicDao extends JpaRepository<Topic, Integer> {

}
