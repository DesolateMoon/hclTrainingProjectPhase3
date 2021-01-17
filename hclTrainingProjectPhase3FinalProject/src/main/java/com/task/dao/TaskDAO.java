package com.task.dao;

import org.springframework.data.repository.CrudRepository;

import com.task.entity.Task;

public interface TaskDAO extends CrudRepository<Task, Integer> {

}
