package com.sw300.developmentservice.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "courseware", path = "coursewares")
public interface CoursewareRepository extends PagingAndSortingRepository<Courseware, Long> {
}
