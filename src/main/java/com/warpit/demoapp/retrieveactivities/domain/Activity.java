package com.warpit.demoapp.retrieveactivities.domain;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Activity {

	@Id
    private String id;
	
	private String activityName;
	
    @Min(0)
    @Max(50)
    private Integer activityDuration;  
    
    @Min(0)
    @Max(10)
    private Integer activityBreak;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime activityStratDate;
    
    private String activityQRCodeURL;
    
    private String activityQRCodeKey;
    
  
	public Activity() {
	}


	public Activity(String activityName, @Min(0) @Max(50) Integer activityDuration,
			@Min(0) @Max(10) Integer activityBreak, LocalDateTime activityStratDate, String activityQRCodeURL,
			String activityQRCodeKey) {
		super();
		this.activityName = activityName;
		this.activityDuration = activityDuration;
		this.activityBreak = activityBreak;
		this.activityStratDate = activityStratDate;
		this.activityQRCodeURL = activityQRCodeURL;
		this.activityQRCodeKey = activityQRCodeKey;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getActivityName() {
		return activityName;
	}


	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}


	public Integer getActivityDuration() {
		return activityDuration;
	}


	public void setActivityDuration(Integer activityDuration) {
		this.activityDuration = activityDuration;
	}


	public Integer getActivityBreak() {
		return activityBreak;
	}


	public void setActivityBreak(Integer activityBreak) {
		this.activityBreak = activityBreak;
	}


	public LocalDateTime getActivityStratDate() {
		return activityStratDate;
	}


	public void setActivityStratDate(LocalDateTime activityStratDate) {
		this.activityStratDate = activityStratDate;
	}





	public String getActivityQRCodeURL() {
		return activityQRCodeURL;
	}


	public void setActivityQRCodeURL(String activityQRCodeURL) {
		this.activityQRCodeURL = activityQRCodeURL;
	}


	public String getActivityQRCodeKey() {
		return activityQRCodeKey;
	}


	public void setActivityQRCodeKey(String activityQRCodeKey) {
		this.activityQRCodeKey = activityQRCodeKey;
	}


	@Override
	public String toString() {
		return "Activity [id=" + id + ", activityName=" + activityName + ", activityDuration=" + activityDuration
				+ ", activityBreak=" + activityBreak + ", activityStratDate=" + activityStratDate
				+ ", activityQRCodeURL=" + activityQRCodeURL + ", activityQRCodeKey=" + activityQRCodeKey + "]";
	}





	

     
	
	
    
    
}
