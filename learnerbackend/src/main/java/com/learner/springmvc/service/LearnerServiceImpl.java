package com.learner.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
 
import org.springframework.stereotype.Service;
 
import com.learner.springmvc.model.Course;

@Service("learnerService")
public class LearnerServiceImpl implements LearnerService {

	private static final AtomicLong counter = new AtomicLong();
    
    private static List<Course> learners;
     
    static{
        learners = populateDummyCourses();
    }
 
    public List<Course> findAllCourses() {
        return learners;
    }
     
    public Course findById(long id) {
        for(Course learner : learners){
            if(learner.getId() == id){
                return learner;
            }
        }
        return null;
    }
     
    public Course findByName(String name) {
        for(Course learner : learners){
            if(learner.getCoursename().equalsIgnoreCase(name)){
                return learner;
            }
        }
        return null;
    }
     
    public void saveCourse(Course learner) {
        learner.setId(counter.incrementAndGet());
        learners.add(learner);
    }
 
    public void updateCourse(Course learner) {
        int index = learners.indexOf(learner);
        learners.set(index, learner);
    }
 
    public void deleteCourseById(long id) {
         
        for (Iterator<Course> iterator = learners.iterator(); iterator.hasNext(); ) {
            Course learner = iterator.next();
            if (learner.getId() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isCourseExist(Course learner) {
        return findByName(learner.getCoursename())!=null;
    }
     
    public void deleteAllCourses(){
        learners.clear();
    }
 
    private static List<Course> populateDummyCourses(){
        List<Course> learners = new ArrayList<Course>();
        learners.add(new Course(counter.incrementAndGet(),"Java Fundamentals", "https://www.pluralsight.com/paths/java-language-fundamentals", "support@pluralsight.com"));
        learners.add(new Course(counter.incrementAndGet(),"AngularJS: Get Started", "https://app.pluralsight.com/library/courses/angularjs-get-started/table-of-contents", "support@pluralsight.com"));
        learners.add(new Course(counter.incrementAndGet(),"AngularJS", "https://angularjs.org/", "https://groups.google.com/g/angular"));
        return learners;
    }
 
}
