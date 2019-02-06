package com.sw300.developmentservice.service;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;

@ApiModel(description="All details about the Instructor")
@Entity
@Data
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String highestEducation;
    private String bankAccount;
    
    

 //   @ManyToOne
 //   @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
 //   private ClassDay classDay;
    // Data 분리에 따라서 키를 받을 수 있도록 수정. 
    private Long classDayId;

    public Instructor() {
    }
    
    

	public Instructor(String firstName, String lastName, String email, String phone, String highestEducation,
			String bankAccount, Long classDayId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.highestEducation = highestEducation;
		this.bankAccount = bankAccount;
		this.classDayId = classDayId;
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

	public String getHighestEducation() {
		return highestEducation;
	}

	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Long getClassDayId() {
		return classDayId;
	}

	public void setClassDayId(Long classDayId) {
		this.classDayId = classDayId;
	}
    
    
}
