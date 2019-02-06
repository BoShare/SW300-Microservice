package com.sw300.developmentservice.service;

import lombok.Data;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(description="All details about the ClassDay")
@Entity
public class LearningObject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @ManyToMany
    private List<Topic> topicList;

    @ManyToMany
    private List<Practice> practiceList;

    public LearningObject() {
    }

    public LearningObject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    
	public LearningObject(String name, String description, List<Topic> topicList, List<Practice> practiceList) {
		super();
		this.name = name;
		this.description = description;
		this.topicList = topicList;
		this.practiceList = practiceList;
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

	public List<Topic> getTopicList() {
		return topicList;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}

	public List<Practice> getPracticeList() {
		return practiceList;
	}

	public void setPracticeList(List<Practice> practiceList) {
		this.practiceList = practiceList;
	}

	@Override
	public String toString() {
		return "LearningObject [id=" + id + ", name=" + name + ", description=" + description + ", topicList="
				+ topicList + ", practiceList=" + practiceList + "]";
	}
    
    
}
