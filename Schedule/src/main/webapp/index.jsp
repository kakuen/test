<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>Top page</title>
		<link rel="stylesheet" href="css/style.css" />
		<link rel="stylesheet" href="css/screen.css" />
	    <link rel="stylesheet" href="css/buttons.css" />
	    
		<link href='http://fonts.googleapis.com/css?family=Josefin+Sans' rel='stylesheet'/>
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' />
	</head>
	
	<body bgcolor="#ffffff" background="http://webdesignrecipes.com/wp-content/uploads/2012/07/heading.jpg">
	
	<body>
		<h1>Calendar Schedule</h1>
		<h2>Please Login!</h2>
		<form action="login.do" method="post">
			<table>
				<tr>
					<th>EmployeeId</th>
					<td><input type="text" name="employeeid" /></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			
			<ul class="column">
			<li>
				<button class="shiny-blue">Login</button>
			</li>
		    </ul>
		    
		</form>
		
		<p class="error">${message}</p>
		
	</body>
</html>