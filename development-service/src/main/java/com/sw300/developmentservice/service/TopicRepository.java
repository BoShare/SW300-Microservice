package com.sw300.developmentservice.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "topic", path = "topics")
public interface TopicRepository extends PagingAndSortingRepository<Topic, Long> {
}
