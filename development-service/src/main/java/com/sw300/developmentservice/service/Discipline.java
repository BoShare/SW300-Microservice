package com.sw300.developmentservice.service;

import lombok.Data;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(description="All details about the Discipline")
@Entity
@Data
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @ManyToMany
    private List<Course> courseList;

    @ManyToMany
    private List<Topic> topicList;

    public Discipline() {
    }

    public Discipline(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    

	public Discipline(String name, String description, List<Course> courseList, List<Topic> topicList) {
		super();
		this.name = name;
		this.description = description;
		this.courseList = courseList;
		this.topicList = topicList;
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

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public List<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}

	@Override
	public String toString() {
		return "Discipline [id=" + id + ", name=" + name + ", description=" + description + ", courseList=" + courseList
				+ ", topicList=" + topicList + "]";
	}
    
    
}
