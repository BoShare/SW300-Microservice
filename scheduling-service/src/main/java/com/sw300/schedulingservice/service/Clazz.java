package com.sw300.schedulingservice.service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ClazzStatus status;
    private double evaluationRate;

//    @ManyToOne
//    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
//    private Course course;
    
    //Data 분리 원칙에 따라서 key값을 받아 오도로록 수정.
    private Long courseId;

    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
    private List<ClassDay> classDayList;

    public Clazz() {
    }

    public Clazz(ClazzStatus status, double evaluationRate) {
        this.status = status;
        this.evaluationRate = evaluationRate;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClazzStatus getStatus() {
		return status;
	}

	public void setStatus(ClazzStatus status) {
		this.status = status;
	}

	public double getEvaluationRate() {
		return evaluationRate;
	}

	public void setEvaluationRate(double evaluationRate) {
		this.evaluationRate = evaluationRate;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public List<ClassDay> getClassDayList() {
		return classDayList;
	}

	public void setClassDayList(List<ClassDay> classDayList) {
		this.classDayList = classDayList;
	}
    
    
}
