package com.sw300.bookingoperationservice.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customer", path = "customers")
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
