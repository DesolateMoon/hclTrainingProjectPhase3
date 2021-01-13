package com.feedback.controller;

import java.util.Comparator;

import com.feedback.entity.Feedback;

public class FeedbackComparator implements Comparator<Feedback> {

	@Override
	public int compare(Feedback o1, Feedback o2) {
		return o2.getId() - o1.getId();
	}

}
