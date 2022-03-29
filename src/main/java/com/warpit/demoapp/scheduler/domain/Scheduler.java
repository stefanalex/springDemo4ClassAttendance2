package com.warpit.demoapp.scheduler.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.warpit.demoapp.retrieveactivities.domain.Activity;

@Document
public class Scheduler {

	@Id
    private String id;
	
	
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime day;
	
	
	private List<Activity> scheduledActivities;
	
	
	protected Scheduler() {
	}


	public Scheduler(LocalDateTime day, List<Activity> scheduledActivities) {
		super();
		this.day = day;
		this.scheduledActivities = scheduledActivities;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public LocalDateTime getDay() {
		return day;
	}


	public void setDay(LocalDateTime day) {
		this.day = day;
	}


	public List<Activity> getScheduledActivities() {
		return scheduledActivities;
	}


	public void setScheduledActivities(List<Activity> scheduledActivities) {
		this.scheduledActivities = scheduledActivities;
	}


	@Override
	public String toString() {
		return "Scheduler [id=" + id + ", day=" + day + ", scheduledActivities=" + scheduledActivities + "]";
	}


	
	
	
	

}
