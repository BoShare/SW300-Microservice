package com.sw300.schedulingservice.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "classday", path = "classdays")
public interface ClassDayRepository extends PagingAndSortingRepository<ClassDay, Long> {
	
}
