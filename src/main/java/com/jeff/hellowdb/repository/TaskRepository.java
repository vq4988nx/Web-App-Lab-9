package com.jeff.hellowdb.repository;

import com.jeff.hellowdb.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}