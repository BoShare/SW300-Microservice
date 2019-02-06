package com.sw300.developmentservice.service;


import lombok.Data;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(description="All details about the Course")
@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private int duration;
    private String description;
    private int maxEnrollment;
    private int minEnrollment;
    private float unitPrice;

 //   @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
  //  private List<Clazz> clazzList;

    @ManyToMany
    private List<Discipline> disciplineList;

    public Course() {
    }

    public Course(String title, int duration, String description, int maxEnrollment,
                  int minEnrollment, float unitPrice) {
        this.title = title;
        this.duration = duration;
        this.description = description;
        this.maxEnrollment = maxEnrollment;
        this.minEnrollment = minEnrollment;
        this.unitPrice = unitPrice;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxEnrollment() {
		return maxEnrollment;
	}

	public void setMaxEnrollment(int maxEnrollment) {
		this.maxEnrollment = maxEnrollment;
	}

	public int getMinEnrollment() {
		return minEnrollment;
	}

	public void setMinEnrollment(int minEnrollment) {
		this.minEnrollment = minEnrollment;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public List<Discipline> getDisciplineList() {
		return disciplineList;
	}

	public void setDisciplineList(List<Discipline> disciplineList) {
		this.disciplineList = disciplineList;
	}
    
    

    //TODO 재귀관계를 어떻게 구현할 것인가
}
