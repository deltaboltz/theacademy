package com.learner.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
 
import com.learner.springmvc.model.Course;
import com.learner.springmvc.service.LearnerService;

@RestController
public class LearnerRestController {

	@Autowired
    LearnerService learnerService;
	
	@RequestMapping(value = "/course/", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> listAllCourses() {
        List<Course> learners = learnerService.findAllCourses();
        if(learners.isEmpty()){
            return new ResponseEntity<List<Course>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Course>>(learners, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/course/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> getCourse(@PathVariable("id") long id) {
        System.out.println("Fetching Course with id " + id);
        Course learner = learnerService.findById(id);
        if (learner == null) {
            System.out.println("Course with id " + id + " not found");
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Course>(learner, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/course/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCourse(@RequestBody Course learner,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Course Request " + learner.getCoursename());
  
        if (learnerService.isCourseExist(learner)) {
            System.out.println("A Course with name " + learner.getCoursename() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        learnerService.saveCourse(learner);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/course/{id}").buildAndExpand(learner.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/course/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course learner) {
        System.out.println("Updating Course " + id);
          
        Course currentCourse = learnerService.findById(id);
          
        if (currentCourse==null) {
            System.out.println("Course with id " + id + " not found");
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
  
        currentCourse.setCoursename(learner.getCoursename());
        currentCourse.setAddress(learner.getAddress());
        currentCourse.setEmail(learner.getEmail());
          
        learnerService.updateCourse(currentCourse);
        return new ResponseEntity<Course>(currentCourse, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Course> deleteCourse(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Course with id " + id);
  
        Course learner = learnerService.findById(id);
        if (learner == null) {
            System.out.println("Unable to delete. Course with id " + id + " not found");
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
  
        learnerService.deleteCourseById(id);
        return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
    }
	
    @RequestMapping(value = "/course/", method = RequestMethod.DELETE)
    public ResponseEntity<Course> deleteAllCourses() {
        System.out.println("Deleting All Courses");
  
        learnerService.deleteAllCourses();
        return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
    }
	
}
