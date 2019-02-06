package com.sw300.schedulingservice.service;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "clazz", path = "clazzs")
public interface ClazzRepository extends PagingAndSortingRepository<Clazz, Long> {
	public List<Clazz> findByCourseId (Long courseId);
}
