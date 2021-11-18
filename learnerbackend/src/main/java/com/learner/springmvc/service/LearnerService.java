package com.learner.springmvc.service;

import java.util.List;

import com.learner.springmvc.model.Course;


public interface LearnerService {
     
    Course findById(long id);
     
    Course findByName(String name);
     
    void saveCourse(Course learner);
     
    void updateCourse(Course learner);
     
    void deleteCourseById(long id);
 
    List<Course> findAllCourses(); 
     
    void deleteAllCourses();
     
    public boolean isCourseExist(Course learner);
     
}
