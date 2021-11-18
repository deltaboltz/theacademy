<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en-US">
  <head>  
    <title>Course Request Page</title>  
    <style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
 
      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
 
    </style>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
  </head>
  
  <header>
		<nav>
			<ul>
				<li>
					<a href="/"> Home </a>
				</li>
				<li>
					<a href="#"> About </a>
				</li>
				<li>
					<a href="#"> Contact </a>
				</li>
				<li> 
					<a href="#"> Terms of use </a>
				</li>
				<li>
					<a href="account"> Account </a>
				</li>
				<li>
					<a href="courserequest"> Course Request </a>
				</li>
				<li>
					<a href="user/new"> User Reg </a>
				</li>
				<li>
					<a href="login"> Log In </a>
				</li>
			</ul>
		</nav>
	</header>
<main>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="LearnerController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Course Request Form For: ${userfname}</span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.course.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="uname">Course Name </label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.course.coursename" id="uname" class="username form-control input-sm" placeholder="Enter the course name" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                      <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                      <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                         
                       
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="address">Course Website </label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.course.address" id="address" class="form-control input-sm" placeholder="Enter the website the course is listed on"/>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="email">Website's Support Email</label>
                              <div class="col-md-7">
                                  <input type="email" ng-model="ctrl.course.email" id="email" class="email form-control input-sm" value= "test" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.course.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Requested Courses </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Course Name</th>
                              <th>Course Website</th>
                              <th>Support Email</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.courses">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.coursename"></span></td>
                              <td><span ng-bind="u.address"></span></td>
                              <td><span ng-bind="u.email"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
       
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="<c:url value='/static/js/app.js' />"></script>
      <script src="<c:url value='/static/js/service/learner_service.js' />"></script>
      <script src="<c:url value='/static/js/controller/learner_controller.js' />"></script>
  </body>
 </main>
</html>