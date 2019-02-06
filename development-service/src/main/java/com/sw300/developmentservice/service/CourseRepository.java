package com.sw300.developmentservice.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "course", path = "courses")
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}
