<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Error</title>
<style>
/* General Reset */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Arial', sans-serif;
}

body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background: linear-gradient(135deg, #ff4b2b, #ff416c);
}

.container {
	background-color: #fff;
	padding: 40px;
	border-radius: 15px;
	box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
	text-align: center;
	max-width: 400px;
	width: 90%;
}

h2.error {
	color: #e74c3c;
	font-size: 28px;
	margin-bottom: 20px;
}

p {
	font-size: 18px;
	color: #555;
	margin-bottom: 30px;
}

button {
	background-color: #ff4b2b;
	color: #fff;
	border: none;
	padding: 12px 20px;
	border-radius: 8px;
	cursor: pointer;
	font-size: 16px;
	transition: all 0.3s ease;
}

button:hover {
	background-color: #ff416c;
	transform: translateY(-3px);
	box-shadow: 0 5px 15px rgba(255, 65, 108, 0.4);
}

button:active {
	transform: translateY(0);
	box-shadow: none;
}
</style>
</head>
</head>
<body>
	<div class="container">
		<h2 class="error">Login Failed</h2>
		<p>Please check your credentials and try again.</p>
		<button onclick="window.location.href='login.jsp'">Back to
			Login</button>
	</div>
</body>
</html>