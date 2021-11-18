package com.learner.springmvc.manager;

import java.util.List;

import com.learner.springmvc.model.CourseView;


public interface CourseManager {
     
    CourseView findById(long id);
     
    CourseView findByName(String name);
     
    void saveCourse(CourseView learner);
     
    void updateCourse(CourseView learner);
     
    void deleteCourseById(long id);
 
    List<CourseView> findAllCourses(); 
     
    void deleteAllCourses();
     
    public boolean isCourseExist(CourseView learner);
     
}
