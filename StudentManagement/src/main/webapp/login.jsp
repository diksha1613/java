<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<style>
/* Basic Reset */
body, h2, p, input, button, a {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
}

/* Body */
body {
	background-color: #9a9aeb;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

/* Container */
.container {
	background-color: white;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	width: 100%;
	max-width: 380px;
	padding: 30px;
	text-align: center;
}

h2 {
	font-size: 24px;
	margin-bottom: 20px;
	color: #333;
}

.success-message {
	color: green;
	font-size: 16px;
	margin-bottom: 20px;
}

/* Form */
form {
	display: flex;
	flex-direction: column;
}

input {
	height: 40px;
	border: 1px solid #ddd;
	border-radius: 4px;
	margin: 10px 0;
	padding: 0 10px;
	font-size: 16px;
}

input:focus {
	outline: none;
	border-color: #0078d4;
}

button {
	background-color: #0078d4;
	color: white;
	border: none;
	padding: 10px;
	font-size: 16px;
	cursor: pointer;
	border-radius: 4px;
	transition: background-color 0.3s ease;
}

button:hover {
	background-color: #005a8d;
}

p {
	margin-top: 10px;
	font-size: 14px;
}

a {
	text-decoration: none;
	color: #0078d4;
}

a:hover {
	text-decoration: underline;
}

/* Responsive Design */
@media screen and (max-width: 400px) {
	.container {
		padding: 20px;
		max-width: 100%;
	}
	input {
		font-size: 14px;
	}
	button {
		font-size: 14px;
		padding: 8px;
	}
}
</style>



</head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div class="container">
		<h2>Login</h2>
		<!-- Display logout message if present -->
		<%
		String message = request.getParameter("message");
		if (message != null) {
		%>
		<p class="success-message"><%=message%></p>
		<%
		}
		%>
		<form action="login" method="post">
			<input type="text" name="email" placeholder="Email or Phone" required>
			<input type="password" name="pwd" placeholder="Password" required>
			<button type="submit">Login</button>
			<p>
				<a href="regi.jsp">Don't have an account? Register here</a>
			</p>
		</form>
	</div>
</body>
</html>