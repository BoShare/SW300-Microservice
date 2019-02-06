package com.sw300.schedulingservice.service;

import lombok.Data;

@Data
public class InstructorInfo {

    private long classDayId;
    private long instructorId;
    
    
	public InstructorInfo(long classDayId, long instructorId) {
		super();
		this.classDayId = classDayId;
		this.instructorId = instructorId;
	}
	public long getClassDayId() {
		return classDayId;
	}
	public void setClassDayId(long classDayId) {
		this.classDayId = classDayId;
	}
	public long getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(long instructorId) {
		this.instructorId = instructorId;
	}
	@Override
	public String toString() {
		return "InstructorInfo [classDayId=" + classDayId + ", instructorId=" + instructorId + "]";
	}
    
	
    


}
