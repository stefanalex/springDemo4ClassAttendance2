package com.warpit.demoapp.retrieveactivities.persistence;

import org.springframework.data.repository.CrudRepository;


import com.warpit.demoapp.retrieveactivities.domain.Activity;

public interface ActivitiesRepository extends CrudRepository<Activity, String>{

}
