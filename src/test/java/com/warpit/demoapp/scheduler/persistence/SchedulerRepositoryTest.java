package com.warpit.demoapp.scheduler.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.warpit.demoapp.retrieveactivities.domain.Activity;
import com.warpit.demoapp.scheduler.domain.Scheduler;

@DataMongoTest
class SchedulerRepositoryTest {

	@Autowired
	private SchedulerRepository schedulerRepository;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	@Test
	public void injectedComponentsAreNotNull() {
		assertThat(schedulerRepository).isNotNull();
	}

	@Test
	void createSchedule() {
		
		String activityQRCodeURL="http://localhost:8080/activities/history/checkIn";
		
		LocalDateTime day = LocalDateTime.parse("2012-04-23 08:00:00",formatter);
		LocalDateTime activityStratDate=LocalDateTime.parse("2012-04-23 14:00:00",formatter);
		Activity activity = new Activity("History",50,10,activityStratDate,activityQRCodeURL,"QAZWSX");
			
		Scheduler scheduler = new Scheduler(day,List.of(activity)) ;
		
		schedulerRepository.save(scheduler);
		assertThat(schedulerRepository.findById(scheduler.getId())).isNotEmpty();
	}
	
	
}
