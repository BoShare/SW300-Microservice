package com.sw300.bookingoperationservice.service;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    //TODO 관계로 전환할지 확인필요
    private String job;
    private String industry;

    private String email;
    private String phone;
    private boolean membership;

    @OneToOne
    private PaymentMethod paymentMethod;
    

    public Customer() {
    }
    
    

    public Customer(String firstName, String lastName, String job, String industry, String email, String phone,
			boolean membership, PaymentMethod paymentMethod) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
		this.industry = industry;
		this.email = email;
		this.phone = phone;
		this.membership = membership;
		this.paymentMethod = paymentMethod;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public String getIndustry() {
		return industry;
	}



	public void setIndustry(String industry) {
		this.industry = industry;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public boolean isMembership() {
		return membership;
	}



	public void setMembership(boolean membership) {
		this.membership = membership;
	}



	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}



	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}



	@Builder
    public Customer(String firstName, String lastName, String job, String industry,  String email, String phone, Boolean membership) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.industry = industry;
        this.email = email;
        this.phone = phone;
        this.membership = membership;
    }
}

