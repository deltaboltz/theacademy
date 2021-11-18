package com.learner.springmvc.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
 
import org.springframework.stereotype.Service;
 
import com.learner.springmvc.model.CourseView;

@Service("courseService")
public class CourseManagerImpl implements CourseManager {

	private static final AtomicLong counter = new AtomicLong();
    
    private static List<CourseView> learners;
     
    static{
        learners = populateDummyCourses();
    }
 
    public List<CourseView> findAllCourses() {
        return learners;
    }
     
    public CourseView findById(long id) {
        for(CourseView learner : learners){
            if(learner.getId() == id){
                return learner;
            }
        }
        return null;
    }
     
    public CourseView findByName(String name) {
        for(CourseView learner : learners){
            if(learner.getCoursename().equalsIgnoreCase(name)){
                return learner;
            }
        }
        return null;
    }
     
    public void saveCourse(CourseView learner) {
        learner.setId(counter.incrementAndGet());
        learners.add(learner);
    }
 
    public void updateCourse(CourseView learner) {
        int index = learners.indexOf(learner);
        learners.set(index, learner);
    }
 
    public void deleteCourseById(long id) {
         
        for (Iterator<CourseView> iterator = learners.iterator(); iterator.hasNext(); ) {
            CourseView learner = iterator.next();
            if (learner.getId() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isCourseExist(CourseView learner) {
        return findByName(learner.getCoursename())!=null;
    }
     
    public void deleteAllCourses(){
        learners.clear();
    }
 
    private static List<CourseView> populateDummyCourses(){
        List<CourseView> learners = new ArrayList<CourseView>();
        learners.add(new CourseView(counter.incrementAndGet(),"Java Fundamentals", "https://www.pluralsight.com/paths/java-language-fundamentals", "support@pluralsight.com"));
        learners.add(new CourseView(counter.incrementAndGet(),"AngularJS: Get Started", "https://app.pluralsight.com/library/courses/angularjs-get-started/table-of-contents", "support@pluralsight.com"));
        learners.add(new CourseView(counter.incrementAndGet(),"AngularJS", "https://angularjs.org/", "https://groups.google.com/g/angular"));
        return learners;
    }
 
}
