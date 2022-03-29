package com.warpit.demoapp.scheduler.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.warpit.demoapp.scheduler.domain.Scheduler;

public interface SchedulerRepository extends MongoRepository<Scheduler, String> {

}
