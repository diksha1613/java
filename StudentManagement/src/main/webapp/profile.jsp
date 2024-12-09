<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.student.management.User"%>
<!DOCTYPE html>


<html>
<head>
<style>
/* General body styling */
body {
	font-family: 'Arial', sans-serif;
	background-color: #DF6D43;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

/* Main container styling */
.container {
	background-color: #ffffff;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
	border-radius: 10px;
	padding: 2em;
	width: 380px;
	text-align: left;
	transition: transform 0.3s ease;
}

/* Animation on hover */
.container:hover {
	transform: scale(1.02);
}

/* Header styling */
h2 {
	color: #4a90e2;
	font-size: 1.8em;
	text-align: center;
	margin-bottom: 1em;
}

/* Profile information styling */
p {
	color: #555;
	font-size: 1em;
	line-height: 1.6;
	margin: 0.5em 0;
}

/* Label styling */
strong {
	color: #333;
	font-weight: bold;
}

/* Button styling */
button {
	background-color: #4a90e2;
	color: #ffffff;
	border: none;
	border-radius: 5px;
	padding: 0.8em 1.5em;
	font-size: 1em;
	cursor: pointer;
	transition: background-color 0.3s ease, transform 0.2s ease;
	width: 100%;
	margin-top: 1.5em;
	display: block;
}

/* Hover effect for button */
button:hover {
	background-color: #357ab7;
	transform: scale(1.05);
}
</style>
<title>Profile</title>
</head>
<body>
	<div class="container">
		<h2>Your Profile</h2>
		<p>
			<strong>Name:</strong>
			<%=((User) session.getAttribute("user")).getName()%></p>
		<p>
			<strong>Email:</strong>
			<%=((User) session.getAttribute("user")).getEmail()%></p>
		<p>
			<strong>Phone:</strong>
			<%=((User) session.getAttribute("user")).getPhone()%></p>
		<p>
			<strong>Student ID:</strong>
			<%=((User) session.getAttribute("user")).getStdId()%></p>
		<form action="dashboard.jsp" method="get">
			<button type="submit">Back to Dashboard</button>
		</form>
	</div>
</body>
</html>

