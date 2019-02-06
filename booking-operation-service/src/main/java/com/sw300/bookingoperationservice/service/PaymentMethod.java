package com.sw300.bookingoperationservice.service;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;
    private String account;

    @OneToOne
    private Customer customer;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL)
    private List<Payment> paymentList;
    
    

	public PaymentMethod(String type, String account, Customer customer, List<Payment> paymentList) {
		super();
		this.type = type;
		this.account = account;
		this.customer = customer;
		this.paymentList = paymentList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	@Override
	public String toString() {
		return "PaymentMethod [id=" + id + ", type=" + type + ", account=" + account + ", customer=" + customer
				+ ", paymentList=" + paymentList + "]";
	}
	
	
    
    
}