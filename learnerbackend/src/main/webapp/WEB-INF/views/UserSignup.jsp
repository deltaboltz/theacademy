<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE Html>
<Html lang="en-US">
<Head>
	<title>User Sign Up</title>
</Head>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
    
    
    
 <body>
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
	<h1>
		Welcome to The Academy
	</h1>	
    <div class="generic-container">
    	<div class="panel panel-default">
    		<div class="formcontainer">
    			<form action="createNewUser" name="myForm" class="form-horizontal">
	    			<div class="row">
	                	<div class="form-group col-md-12">
	    
							
								<label class="col-md-2 control-lable">First Name: </label>
								<div class="col-md-7">	
									<input type="text" name="firstName" class="username form-control input-sm" placeholder="John" required>
								</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-12">		
							<label class="col-md-2 control-lable">Last Name:  </label>
							
							<div class="col-md-7">
								<input type="text" name="lastName" class="username form-control input-sm" placeholder="Doe" required><br>
							</div>
						</div>
					</div>
					
					
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable">User Name: </label>
							
							<div class="col-md-7">
								<input type="text" name="userName" class="username form-control input-sm" placeholder="Enter Username" required><br>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable">Email: </label>
							
							<div class="col-md-7">
								<input type="email" name="email" class="username form-control input-sm" placeholder="jdoe@mail.com" required><br>
							</div>
						</div>
					</div>
					
					<div class="row">
                    	<div class="form-actions floatRight">
							<input type="submit" class="btn btn-primary btn-sm">
						</div>
					</div>
				</form>
					
			</div>
		</div>
	</div>
</main>
</body>
</Html>