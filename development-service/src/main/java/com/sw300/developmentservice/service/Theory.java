package com.sw300.developmentservice.service;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about the Theory")
@Entity
@Data
public class Theory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated Theory ID")
    private Long id;

    @ApiModelProperty(notes = "This is the Theory name")
    @Size(min=2, message="name should have at least 2 characters")
    private String name;
    
    @ApiModelProperty(notes = "This is the Theory desccription")
    @Size(min=2, message="name should have at least 5 characters")
    private String description;

    public Theory() {
    }

    public Theory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Theory [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
    
    
}
