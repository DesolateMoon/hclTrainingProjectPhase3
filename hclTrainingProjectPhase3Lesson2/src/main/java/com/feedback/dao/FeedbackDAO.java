package com.feedback.dao;

import org.springframework.data.repository.CrudRepository;

import com.feedback.entity.Feedback;

public interface FeedbackDAO extends CrudRepository<Feedback, Integer> {

}
