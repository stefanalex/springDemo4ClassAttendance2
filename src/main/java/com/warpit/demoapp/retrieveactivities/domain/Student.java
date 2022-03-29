package com.warpit.demoapp.retrieveactivities.domain;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
	
	@Id
    private String id;
	
	private Map<String, String> attendeeInfo;
	
	//register activities
	private Map<String, Activity> activities;
	
	

}
