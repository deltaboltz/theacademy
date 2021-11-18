'use strict';
 
angular.module('myApp').factory('LearnerService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/learner/course/';
 
    var factory = {
        fetchAllCourses: fetchAllCourses,
        createCourse: createCourse,
        updateCourse:updateCourse,
        deleteCourse:deleteCourse
    };
 
    return factory;
 
    function fetchAllCourses() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Courses');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createCourse(course) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, course)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Courses');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateCourse(course, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, course)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Courses');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteCourse(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Courses');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);