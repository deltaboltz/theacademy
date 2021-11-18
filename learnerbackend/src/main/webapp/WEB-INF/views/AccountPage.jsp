<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE Html>
<Html lang="en-US">   
<Head>    
<Title>User Account</Title>
	<style type=text/css> 
		body{
			height: 125vh;
			margin-top: 80px;
			padding: 30px;
			background-size: cover;
			background-color: black;
			color: white;
			font-family: sans-serif;
		}
		header {
			background-color: #E67E00;
			position: fixed;
			left: 0;
			right: 0;
			top: 5px;
			height: 30px;
			display: flex;
			align-items: center;
			box-shadow: 0 0 25px 0 #E67E00;
		}
		header * {
			display: inline;
		}
		header li {
			margin: 20px;
		}
		header li a {
			color: black;
			text-decoration: none;
		}
	</style> 
</Head>
<Body> 
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
			Welcome to your account: ${userfname}
		</h1>
	
		<h2>
			We will be adding more content in the future, don't forget the email you signed up with! ${email}
		</h2>
	</main>
	
		
</Body> 
</Html>