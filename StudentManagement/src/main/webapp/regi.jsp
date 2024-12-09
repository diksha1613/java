<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
/* General body styling */
body {
	font-family: Arial, sans-serif;
	background-color: #f0f4f8;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

/* Main container styling */
.container {
	background-color: #ffffff;
	box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
	border-radius: 12px;
	padding: 2em;
	width: 400px;
	text-align: center;
	transition: transform 0.3s ease;
}

/* Container hover effect */
.container:hover {
	transform: scale(1.02);
}

/* Header styling */
h2 {
	color: #3498db;
	font-size: 1.8em;
	margin-bottom: 1em;
}

/* Success message styling */
.success-message {
	background-color: #dff0d8;
	color: #3c763d;
	padding: 0.8em;
	border-radius: 6px;
	margin-bottom: 1em;
	font-size: 0.95em;
}

/* Input field styling */
input[type="text"], input[type="email"], input[type="password"] {
	width: calc(100% - 20px);
	padding: 0.8em;
	margin: 0.5em 0;
	border: 1px solid #ddd;
	border-radius: 6px;
	font-size: 1em;
	transition: border-color 0.3s ease;
}

/* Focus effect on input fields */
input[type="text"]:focus, input[type="email"]:focus, input[type="password"]:focus
	{
	border-color: #3498db;
	outline: none;
}

/* Button styling */
button {
	background-color: #28b485;
	color: #ffffff;
	border: none;
	border-radius: 8px;
	padding: 0.8em 1.5em;
	font-size: 1em;
	cursor: pointer;
	transition: background-color 0.3s ease, transform 0.2s ease;
	width: 100%;
	margin-top: 1em;
}

/* Button hover effect */
button:hover {
	background-color: #1f8f6e;
	transform: scale(1.03);
}

/* Link styling */
a {
	color: #3498db;
	text-decoration: none;
	transition: color 0.3s ease;
}

/* Link hover effect */
a:hover {
	color: #216f99;
}
</style>
<title>Register</title>
</head>
<body>
	<div class="container">
		<h2>Register</h2>
		<!-- Display message if present -->
		<%
		String message = request.getParameter("message");
		if (message != null) {
		%>
		<p class="success-message"><%=message%></p>
		<%
		}
		%>
		<form action="register" method="post">
			<input type="text" name="name" placeholder="Name" required> <input
				type="email" name="email" placeholder="Email" required> <input
				type="text" name="phone" placeholder="Phone" required> <input
				type="text" name="std" placeholder="Student ID" required> <input
				type="password" name="pwd" placeholder="Password" required>
			<button type="submit">Register</button>
			<p>
				<a href="login.jsp">Already have an account? Login here</a>
			</p>
		</form>
	</div>
</body>
</html>