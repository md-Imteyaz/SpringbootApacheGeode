package com.SpringbootApacheGeode.Repo;

import org.springframework.data.gemfire.repository.query.annotation.Trace;
import org.springframework.data.repository.CrudRepository;

import com.SpringbootApacheGeode.model.Visitors;

public interface VisitorsRepo extends CrudRepository<Visitors, Long> {

	@Trace
	Visitors findByNameLike(String name);
}
