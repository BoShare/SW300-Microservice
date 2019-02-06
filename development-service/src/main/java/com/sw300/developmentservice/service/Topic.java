package com.sw300.developmentservice.service;

import lombok.Data;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(description="All details about the ClassDay")
@Entity
@Data
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @ManyToMany
    private List<LearningObject> learningObjectList;

    @ManyToMany
    private List<Discipline> disciplineList;
    
    public Topic() {
		
	}

	public Topic(String name, String description, List<LearningObject> learningObjectList,
			List<Discipline> disciplineList) {
		super();
		this.name = name;
		this.description = description;
		this.learningObjectList = learningObjectList;
		this.disciplineList = disciplineList;
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

	public List<LearningObject> getLearningObjectList() {
		return learningObjectList;
	}

	public void setLearningObjectList(List<LearningObject> learningObjectList) {
		this.learningObjectList = learningObjectList;
	}

	public List<Discipline> getDisciplineList() {
		return disciplineList;
	}

	public void setDisciplineList(List<Discipline> disciplineList) {
		this.disciplineList = disciplineList;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + ", description=" + description + ", learningObjectList="
				+ learningObjectList + ", disciplineList=" + disciplineList + "]";
	}
    
    
}
