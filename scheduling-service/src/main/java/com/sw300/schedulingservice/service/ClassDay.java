package com.sw300.schedulingservice.service;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@ApiModel(description="All details about the ClassDay")
@Entity
@Data
public class ClassDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated product ID")
    private Long id;

    private int number;
    private Date date;
    private Date startTime;
    private Date endTime;
    private int instructorPay;

    @ManyToOne
    @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
    private Clazz clazz;

    @ManyToOne
    private Venu venu;

//    @OneToMany(mappedBy = "classDay", cascade = CascadeType.ALL)
//    private List<Instructor> instructorList;

    public ClassDay(){}

    public ClassDay(int number, Date date, Date startTime, Date endTime, int instructorPay) {
        this.number = number;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.instructorPay = instructorPay;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getInstructorPay() {
		return instructorPay;
	}

	public void setInstructorPay(int instructorPay) {
		this.instructorPay = instructorPay;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Venu getVenu() {
		return venu;
	}

	public void setVenu(Venu venu) {
		this.venu = venu;
	}

	@Override
	public String toString() {
		return "ClassDay [id=" + id + ", number=" + number + ", date=" + date + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", instructorPay=" + instructorPay + ", clazz=" + clazz + ", venu=" + venu
				+ "]";
	}
    
    
}
