package com.sw300.developmentservice.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "discipline", path = "disciplines")
public interface DisciplineRepository extends PagingAndSortingRepository<Discipline, Long> {
}
