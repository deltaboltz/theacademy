'use strict';
 
angular.module('myApp').controller('LearnerController', ['$scope', 'LearnerService', function($scope, LearnerService) {
    var self = this;
    self.course={id:null,coursename:'',address:'',email:''};
    self.courses=[];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
 
 
    fetchAllCourses();
 
    function fetchAllCourses(){
        LearnerService.fetchAllCourses()
            .then(
            function(d) {
                self.courses = d;
            },
            function(errResponse){
                console.error('Error while fetching Courses');
            }
        );
    }
 
    function createCourse(course){
        LearnerService.createCourse(course)
            .then(
            fetchAllCourses,
            function(errResponse){
                console.error('Error while creating Course');
            }
        );
    }
 
    function updateCourse(course, id){
        LearnerService.updateCourse(course, id)
            .then(
            fetchAllCourses,
            function(errResponse){
                console.error('Error while updating Course');
            }
        );
    }
 
    function deleteCourse(id){
        LearnerService.deleteCourse(id)
            .then(
            fetchAllCourses,
            function(errResponse){
                console.error('Error while deleting Course');
            }
        );
    }
 
    function submit() {
        if(self.course.id===null){
            console.log('Saving New Course', self.course);
            createCourse(self.course);
        }else{
            updateCourse(self.course, self.course.id);
            console.log('Course updated with id ', self.course.id);
        }
        reset();
    }
 
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.courses.length; i++){
            if(self.courses[i].id === id) {
                self.course = angular.copy(self.courses[i]);
                break;
            }
        }
    }
 
    function remove(id){
        console.log('id to be deleted', id);
        if(self.course.id === id) {//clean form if the course to be deleted is shown there.
            reset();
        }
        deleteCourse(id);
    }
 
 
    function reset(){
        self.course={id:null,coursename:'',address:'',email:''};
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);