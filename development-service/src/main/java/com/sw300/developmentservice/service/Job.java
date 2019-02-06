package com.sw300.developmentservice.service;

import lombok.Data;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(description="All details about the Job")
@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private int level;
    private String description;

    @ManyToMany
    private List<Practice> practiceList;

    @ManyToMany
    private  List<Theory> theoryList;

    @ManyToMany
    private List<LearningObject> learningObjectList;

    @ManyToMany
    private List<Industry> industryList;

    public Job() {
    }

    
    public Job(String title, int level, String description, List<Practice> practiceList, List<Theory> theoryList,
			List<LearningObject> learningObjectList, List<Industry> industryList) {
		super();
		this.title = title;
		this.level = level;
		this.description = description;
		this.practiceList = practiceList;
		this.theoryList = theoryList;
		this.learningObjectList = learningObjectList;
		this.industryList = industryList;
	}


	public Job(String title, int level, String description) {
        this.title = title;
        this.level = level;
        this.description = description;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Practice> getPracticeList() {
		return practiceList;
	}

	public void setPracticeList(List<Practice> practiceList) {
		this.practiceList = practiceList;
	}

	public List<Theory> getTheoryList() {
		return theoryList;
	}

	public void setTheoryList(List<Theory> theoryList) {
		this.theoryList = theoryList;
	}

	public List<LearningObject> getLearningObjectList() {
		return learningObjectList;
	}

	public void setLearningObjectList(List<LearningObject> learningObjectList) {
		this.learningObjectList = learningObjectList;
	}

	public List<Industry> getIndustryList() {
		return industryList;
	}

	public void setIndustryList(List<Industry> industryList) {
		this.industryList = industryList;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", level=" + level + ", description=" + description
				+ ", practiceList=" + practiceList + ", theoryList=" + theoryList + ", learningObjectList="
				+ learningObjectList + ", industryList=" + industryList + "]";
	}
    
    
}
