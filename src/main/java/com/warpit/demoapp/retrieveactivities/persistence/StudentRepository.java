package com.warpit.demoapp.retrieveactivities.persistence;

import org.springframework.data.repository.CrudRepository;

import com.warpit.demoapp.retrieveactivities.domain.Student;

public interface StudentRepository extends CrudRepository<Student, String>  {

}
