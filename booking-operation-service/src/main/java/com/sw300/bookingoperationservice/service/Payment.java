package com.sw300.bookingoperationservice.service;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;
    private int amount;

    @ManyToOne(fetch=FetchType.LAZY)
    private PaymentMethod paymentMethod;

    public Payment() {
    }
    
    

	public Payment(Date date, int amount, PaymentMethod paymentMethod) {
		super();
		this.date = date;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
    
    
}
