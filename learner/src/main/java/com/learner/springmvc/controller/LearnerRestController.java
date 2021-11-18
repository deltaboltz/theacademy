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

import com.learner.springmvc.manager.CourseManager;
import com.learner.springmvc.model.CourseView;

@RestController
public class LearnerRestController {

	@Autowired
    CourseManager learnerService;
	
	@RequestMapping(value = "/course/", method = RequestMethod.GET)
    public ResponseEntity<List<CourseView>> listAllCourses() {
        List<CourseView> learners = learnerService.findAllCourses();
        if(learners.isEmpty()){
            return new ResponseEntity<List<CourseView>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<CourseView>>(learners, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/course/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseView> getCourse(@PathVariable("id") long id) {
        System.out.println("Fetching Course with id " + id);
        CourseView learner = learnerService.findById(id);
        if (learner == null) {
            System.out.println("Course with id " + id + " not found");
            return new ResponseEntity<CourseView>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CourseView>(learner, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/course/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCourse(@RequestBody CourseView learner,    UriComponentsBuilder ucBuilder) {
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
    public ResponseEntity<CourseView> updateCourse(@PathVariable("id") long id, @RequestBody CourseView learner) {
        System.out.println("Updating Course " + id);
          
        CourseView currentCourse = learnerService.findById(id);
          
        if (currentCourse==null) {
            System.out.println("Course with id " + id + " not found");
            return new ResponseEntity<CourseView>(HttpStatus.NOT_FOUND);
        }
  
        currentCourse.setCoursename(learner.getCoursename());
        currentCourse.setAddress(learner.getAddress());
        currentCourse.setEmail(learner.getEmail());
          
        learnerService.updateCourse(currentCourse);
        return new ResponseEntity<CourseView>(currentCourse, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/course/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CourseView> deleteCourse(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Course with id " + id);
  
        CourseView learner = learnerService.findById(id);
        if (learner == null) {
            System.out.println("Unable to delete. Course with id " + id + " not found");
            return new ResponseEntity<CourseView>(HttpStatus.NOT_FOUND);
        }
  
        learnerService.deleteCourseById(id);
        return new ResponseEntity<CourseView>(HttpStatus.NO_CONTENT);
    }
	
    @RequestMapping(value = "/course/", method = RequestMethod.DELETE)
    public ResponseEntity<CourseView> deleteAllCourses() {
        System.out.println("Deleting All Courses");
  
        learnerService.deleteAllCourses();
        return new ResponseEntity<CourseView>(HttpStatus.NO_CONTENT);
    }
	
}
