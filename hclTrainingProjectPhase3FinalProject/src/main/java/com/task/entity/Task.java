package com.task.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String start;
	private String end;
	private String description;
	private String email;
	private String severity;
	
	public Task(String name, String start, String end, String description, String email, String severity) {
		super();
		this.name = name;
		this.start = start;
		this.end = end;
		this.description = description;
		this.email = email;
		this.severity = severity;
	}
}
