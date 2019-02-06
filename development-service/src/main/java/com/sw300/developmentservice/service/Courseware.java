package com.sw300.developmentservice.service;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;

@ApiModel(description="All details about the ClassDay")
@Entity
@Data
public class Courseware {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private CoursewareType type;
    private String title;
    private String authorType;

    public Courseware() {
    }

    public Courseware(CoursewareType type, String title, String authorType) {
        this.type = type;
        this.title = title;
        this.authorType = authorType;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CoursewareType getType() {
		return type;
	}

	public void setType(CoursewareType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorType() {
		return authorType;
	}

	public void setAuthorType(String authorType) {
		this.authorType = authorType;
	}

	@Override
	public String toString() {
		return "Courseware [id=" + id + ", type=" + type + ", title=" + title + ", authorType=" + authorType + "]";
	}
    
    
    
}
