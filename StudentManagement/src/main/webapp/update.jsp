<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.student.management.User"%>
<!DOCTYPE html>
<html>
<head>
<style>
/* General body styling */
body {
	font-family: Arial, sans-serif;
	background-color: 	#82EBC8;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

/* Main container styling */
.container {
	background-color: #ffffff;
	box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
	border-radius: 12px;
	padding: 2em;
	width: 350px;
	text-align: center;
	transition: transform 0.3s ease;
}

/* Animation on hover */
.container:hover {
	transform: scale(1.02);
}

/* Header styling */
h2 {
	color: #3498db;
	font-size: 1.8em;
	margin-bottom: 1em;
}

/* Input field styling */
input[type="text"], input[type="email"], input[type="password"] {
	width: calc(100% - 20px);
	padding: 0.8em;
	margin: 0.5em 0;
	border: 1px solid #ddd;
	border-radius: 6px;
	font-size: 1em;
	transition: border 0.3s ease;
}

/* Focus effect on input fields */
input[type="text"]:focus, input[type="email"]:focus, input[type="password"]:focus
	{
	border-color: #3498db;
	outline: none;
}

/* Read-only email field styling */
input[type="email"][readonly] {
	background-color: #f0f0f0;
	color: #888;
	cursor: not-allowed;
}

/* Button styling */
button {
	background-color: 		#E97ABD;
	color: #ffffff;
	border: none;
	border-radius: 6px;
	padding: 0.8em 1.2em;
	font-size: 1em;
	cursor: pointer;
	transition: background-color 0.3s ease, transform 0.2s ease;
	width: 100%;
	margin-top: 1em;
}

/* Button hover effect */
button:hover {
	background-color: #2980b9;
	transform: scale(1.03);
}

/* Style for the "Back to Dashboard" button */
button[type="submit"]:nth-of-type(2) {
	background-color: #7f8c8d;
	margin-top: 0.5em;
}

/* Hover effect for "Back to Dashboard" button */
button[type="submit"]:nth-of-type(2):hover {
	background-color: #566573;
}
</style>
<title>Update Profile</title>
</head>
<body>
	<div class="container">
		<h2>Update Profile</h2>
		<form action="update" method="post">
			<input type="text" name="name" placeholder="Name"
				value="<%=((User) session.getAttribute("user")).getName()%>"
				required>
			<!-- Email Field (Read-Only) -->
			<input type="email" name="email" placeholder="Email"
				value="<%=((User) session.getAttribute("user")).getEmail()%>"
				readonly
				style="background-color: #f0f0f0; color: #888; cursor: not-allowed;">
			<input type="text" name="phone" placeholder="Phone"
				value="<%=((User) session.getAttribute("user")).getPhone()%>"
				required> <input type="text" name="std"
				placeholder="Student ID"
				value="<%=((User) session.getAttribute("user")).getStdId()%>">
			<input type="password" name="pwd" placeholder="New Password" required>
			<button type="submit">Update</button>
		</form>
		<form action="dashboard.jsp" method="get">
			<button type="submit">Back to Dashboard</button>
		</form>
	</div>
</body>
</html>