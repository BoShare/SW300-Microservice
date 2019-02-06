package com.sw300.developmentservice.service;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "instructor", path = "instructors")
public interface InstructorRepository extends PagingAndSortingRepository<Instructor, Long> {
	public List<Instructor> findByClassDayId (Long classDayId);
}
