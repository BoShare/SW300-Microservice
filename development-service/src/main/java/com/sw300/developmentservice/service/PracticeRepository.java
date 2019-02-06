package com.sw300.developmentservice.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "practice", path = "practices")
public interface PracticeRepository extends PagingAndSortingRepository<Practice, Long> {
}
