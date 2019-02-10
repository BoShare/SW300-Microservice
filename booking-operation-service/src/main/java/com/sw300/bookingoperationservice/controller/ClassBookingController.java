package com.sw300.bookingoperationservice.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sw300.bookingoperationservice.exception.CustomizedNotFoundException;
import com.sw300.bookingoperationservice.service.Customer;
import com.sw300.bookingoperationservice.service.CustomerRepository;
import com.sw300.bookingoperationservice.service.Enrollment;
import com.sw300.bookingoperationservice.service.EnrollmentPK;
import com.sw300.bookingoperationservice.service.EnrollmentRepository;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;

@RefreshScope
@RestController
public class ClassBookingController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	

	
	//모든 정보 가져오
	@GetMapping("/customers")
	public Iterable<Customer> retrieveCustomerAll() {
		
		return customerRepository.findAll();
		
	}
	
	//customer ID에 따른 결과 
	@ApiOperation(value = "Customer 현재 상황에 대한 API")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "Customer에 해당하는 유닉크 키값", required = true, dataType = "string", paramType = "query", defaultValue = ""),
    })
	@GetMapping("/customers/{id}")
	public Resource<Customer> retrieveCustomer (@PathVariable long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (!customer.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		Resource<Customer> resource = new Resource<Customer>(customer.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveCustomerAll());
		
		resource.add(linkTo.withRel("/all-customers"));
		
		return resource;
		
	}
	
	//Data insert를 위한 부
	@PostMapping("/customers")
	public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer customer) {
		
		customerRepository.save(customer);
	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(customer.getId())
			.toUri();
				
		return ResponseEntity.created(location).build();
		
	} 
	
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable long id) {
		
		Optional<Customer> customer = customerRepository.findById(id);
		if (!customer.isPresent())
			throw new CustomizedNotFoundException ("id - " + id);
		
		customerRepository.delete(customer.get());
		
	}

	
	//모든 정보 가져오
	@GetMapping("/enrollments")
	public Iterable<Enrollment> retrieveEnrollmentAll() {
		
		return enrollmentRepository.findAll();
		
	}
	
	//customer ID에 따른 결과 
	@GetMapping("/enrollments/{id}")
	public Resource<Enrollment> retrieveCustomer (@PathVariable EnrollmentPK id) {
		Optional<Enrollment> enrollment = enrollmentRepository.findById(id);
		if (!enrollment.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		Resource<Enrollment> resource = new Resource<Enrollment>(enrollment.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveEnrollmentAll());
		
		resource.add(linkTo.withRel("/all-Enrollments"));
		
		return resource;
		
	}
	
	//Data insert를 위한 부
	@PostMapping("/enrollment")
	public ResponseEntity<Object> createEnrollment(@Valid @RequestBody Enrollment enrollment) {
		
		//class id 와 customerId 피요
		// class id 는 scheduing-service에 있어야 함 중요....
		//EnrollmentPK로 만들어 주어야 하나? // 데이터를 가져올 수가 없음 - 아니면 Enrollment에 두개의 데이터를 넣어서 다시 조합을 해야 
		
		enrollmentRepository.save(enrollment);
	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(enrollment.getPk())
			.toUri();
				
		return ResponseEntity.created(location).build();
		
	} 
	
	@DeleteMapping("/enrollment/{id}")
	public void deleteCustomer(@PathVariable EnrollmentPK id) {
		
		Optional<Enrollment> enrollment = enrollmentRepository.findById(id);
		if (!enrollment.isPresent())
			throw new CustomizedNotFoundException ("id - " + id);
		
		enrollmentRepository.delete(enrollment.get());
		
	}
	
	
	
	
	
}
