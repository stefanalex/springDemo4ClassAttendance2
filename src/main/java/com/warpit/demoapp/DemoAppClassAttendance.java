package com.warpit.demoapp;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.warpit.demoapp.retrieveactivities.domain.Activity;
import com.warpit.demoapp.scheduler.service.SchedulerService;





@SpringBootApplication
public class DemoAppClassAttendance implements CommandLineRunner{

	@Autowired
	private SchedulerService schedulerService;
	
	@Value("classpath:${scheduler.importfile}")
	private Resource resource;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoAppClassAttendance.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createScheduleData(resource);
		
	}
	
	
	 /**
     * Create schedule entities from an external file
     */
    private void createScheduleData(Resource fileToImport) throws IOException {
    	SchedulerFromFile.read(fileToImport).forEach(scheduler->
    	               schedulerService.createScheduler(scheduler.day, scheduler.activitiesList) );
                      

    }

	
	 /**
     * Helper class to import Scheduler.json for a MongoDb Document.
     * Only interested in the title and package name, the remaining fields
     * are a collection of key-value pairs
     *
     */
    private static class SchedulerFromFile {
      
    	List<Activity> activitiesList; 
    	LocalDateTime day;
    	
    	//List
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	

        @SuppressWarnings("unchecked")
		SchedulerFromFile(Map<String, Object> record) {
        
        	this.day = LocalDateTime.parse((String)record.get("day"),formatter);
        	this.activitiesList =  (List<Activity>) record.get("activities");
        }
        
        //reader
        static List<SchedulerFromFile> read(Resource fileToImport) throws IOException {
        	
        	InputStream fileToImportStream = fileToImport.getInputStream();
        	
            List<Map<String, Object>> records = new ObjectMapper().setVisibility(FIELD, ANY).
                    readValue(fileToImportStream,
                            new TypeReference<List<Map<String, Object>>>() {});
            return records.stream().map(SchedulerFromFile::new).collect(Collectors.toList());
        }

	
		public LocalDateTime getDay() {
			return day;
		}

	

		public List<Activity> getActivitiesList() {
			return activitiesList;
		}

		@Override
		public String toString() {
			return "SchedulerFromFile [activitiesList=" + activitiesList + ", day=" + day + "]";
		}

        
        
        
       
    }
	
}
