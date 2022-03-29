package com.warpit.demoapp.scheduler.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warpit.demoapp.retrieveactivities.domain.Activity;
import com.warpit.demoapp.scheduler.domain.Scheduler;
import com.warpit.demoapp.scheduler.persistence.SchedulerRepository;

@Service
public class SchedulerService {
	
	@Autowired
	private SchedulerRepository schedulerRepository;


	
	    public Scheduler createScheduler(LocalDateTime day, List<Activity> scheduledActivities) {
	        return schedulerRepository.save(new Scheduler(day, scheduledActivities));
	    }
	    

}
