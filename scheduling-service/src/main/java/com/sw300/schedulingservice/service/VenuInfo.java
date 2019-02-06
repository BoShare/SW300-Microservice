package com.sw300.schedulingservice.service;

import lombok.Data;

@Data
public class VenuInfo {
    private long classDayId;
    private long venuId;
    
    public VenuInfo() {

	}
    
	public VenuInfo(long classDayId, long venuId) {
		super();
		this.classDayId = classDayId;
		this.venuId = venuId;
	}
	public long getClassDayId() {
		return classDayId;
	}
	public void setClassDayId(long classDayId) {
		this.classDayId = classDayId;
	}
	public long getVenuId() {
		return venuId;
	}
	public void setVenuId(long venuId) {
		this.venuId = venuId;
	}
	@Override
	public String toString() {
		return "VenuInfo [classDayId=" + classDayId + ", venuId=" + venuId + "]";
	}
    
    
}
