<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Registration Form</title>
 
 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>

	 	<header>
		<nav>
			<ul>
				<li>
					<a href="index"> Home </a>
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
 
    <h2>Log In</h2>
  
  	<div class="generic-container">
    	<div class="panel panel-default">
    		<div class="formcontainer">
			    <form:form method="POST" modelAttribute="user" class="form-horizontal">
					
					<div class="row">
	                	<div class="form-group col-md-12">
								<label for="email" class="col-md-2 control-lable">Email: </label>
								<div class="col-md-7">
									<form:input type="email" path="email" id="email" class="form-control input-sm" placeholder="jdoe@mail.com" required="required"/>
			                		<form:errors path="email" cssClass="error"/>
								</div>
						</div>
					</div>
					
					<div class="row">
	                	<div class="form-group col-md-12">
								<label for="password" class="col-md-2 control-lable">Password: </label>
								<div class="col-md-7">
									<form:input type="password" path="password" id="password" class="form-control input-sm" required="required"/>
			                		<form:errors path="password" cssClass="error"/>
								</div>
						</div>
					</div>
					<div class="row">
                    	<div class="form-actions floatRight">
		                	<input type="submit" value="Login"/>
		                </div>
					</div>
			    </form:form>
			 </div>
		</div>
	</div>
    <br/>
    <br/>
</body>
</html>