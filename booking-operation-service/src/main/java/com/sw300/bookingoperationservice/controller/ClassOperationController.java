package com.sw300.bookingoperationservice.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.sw300.bookingoperationservice.exception.CustomizedNotFoundException;
import com.sw300.bookingoperationservice.service.Payment;
import com.sw300.bookingoperationservice.service.PaymentMethod;
import com.sw300.bookingoperationservice.service.PaymentMethodRepository;
import com.sw300.bookingoperationservice.service.PaymentRepository;

@RestController
public class ClassOperationController {
	
	@Autowired
	private PaymentMethodRepository paymentMethodRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	//모든 정보 가져오
	@GetMapping("/paymentMethods")
	public Iterable<PaymentMethod> retrievePaymentMethodAll() {
		
		return paymentMethodRepository.findAll();
		
	}
	
	//customer ID에 따른 결과 
	@GetMapping("/paymentMethods/{id}")
	public Resource<PaymentMethod> retrievePaymentMethod (@PathVariable long id) {
		Optional<PaymentMethod> paymentMethod = paymentMethodRepository.findById(id);
		if (!paymentMethod.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		Resource<PaymentMethod> resource = new Resource<PaymentMethod>(paymentMethod.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrievePaymentMethodAll());
		
		resource.add(linkTo.withRel("/all-paymentMethods"));
		
		return resource;
		
	}
	
	//Data insert를 위한 부
	@PostMapping("/paymentMethods")
	public ResponseEntity<Object> createPaymentMethod(@Valid @RequestBody PaymentMethod paymentMethod) {
		
		paymentMethodRepository.save(paymentMethod);
	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(paymentMethod.getId())
			.toUri();
				
		return ResponseEntity.created(location).build();
		
	} 
	
	@DeleteMapping("/paymentMethods/{id}")
	public void deletePaymentMethod(@PathVariable long id) {
		
		Optional<PaymentMethod> paymentMethod = paymentMethodRepository.findById(id);
		if (!paymentMethod.isPresent())
			throw new CustomizedNotFoundException ("id - " + id);
		
		paymentMethodRepository.delete(paymentMethod.get());
		
	}
	
	
	//모든 정보 가져오
	@GetMapping("/paymentMethods/{id}/payments")
	public List<Payment> retrievePaymentAll(@PathVariable long id) {
		
		Optional<PaymentMethod> paymentMethod = paymentMethodRepository.findById(id);
		if (!paymentMethod.isPresent()) {
			throw new CustomizedNotFoundException("id - " + id);
		}
		
		//return service.findAll();
		return paymentMethod.get().getPaymentList();
		
	}
	
	//customer ID에 따른 결과 
	@GetMapping("/payments/{id}")
	public Resource<Payment> retrievePayment (@PathVariable long id) {
		
		Optional<Payment> payment = paymentRepository.findById(id);
		if (!payment.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		
		Resource<Payment> resource = new Resource<Payment>(payment.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrievePaymentMethodAll());
		
		resource.add(linkTo.withRel("/all-paymentMethods"));
		
		return resource;
		
	}
	
	//GET /payments
	//retrieveAllUsers
	@GetMapping("/payments/{id}/paymentMethod")
	public PaymentMethod retrievePaymentAllPaymentMethod(@PathVariable long id) {
		
		Optional<Payment> payments = paymentRepository.findById(id);
		if (!payments.isPresent()) {
			throw new CustomizedNotFoundException("id - " + id);
		}
		
		//return service.findAll();
		return payments.get().getPaymentMethod();
	}
	
	//Data insert를 위한 부
	@PostMapping("/payments/{id}/paymentMethod")
	public ResponseEntity<Object> createPaymentForPaymentMethod(
			@PathVariable long id, @RequestBody PaymentMethod paymentMethod) {
		
		Optional<Payment> payments = paymentRepository.findById(id);
		if (!payments.isPresent()) {
			throw new CustomizedNotFoundException("id - " + id);
		}
		
		Payment payment = payments.get();
		List<Payment> paymentList = new ArrayList<Payment>();
		paymentList.add(payment);
		
		paymentMethod.setPaymentList (paymentList);
		
		paymentMethodRepository.save(paymentMethod);

		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(paymentMethod.getId())
			.toUri();
	
		
		return ResponseEntity.created(location).build();
		
	} 
	

	
	
}
