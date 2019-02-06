package com.sw300.bookingoperationservice.service;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Enrollment {
    @Id
    private EnrollmentPK pk;

    private String status;
    private Date date;
    private int grade;

    public Enrollment() {
    }
    
    

	public Enrollment(String status, Date date, int grade) {
		super();
		this.status = status;
		this.date = date;
		this.grade = grade;
	}



	public EnrollmentPK getPk() {
		return pk;
	}

	public void setPk(EnrollmentPK pk) {
		this.pk = pk;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Enrollment [pk=" + pk + ", status=" + status + ", date=" + date + ", grade=" + grade + "]";
	}
    
    
}
