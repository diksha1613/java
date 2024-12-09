<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.student.management.User"%>

<!DOCTYPE html>
<html>
<head>
<style>
/* General body styling */
body {
font-family: Arial, sans-serif;
background-color: #7DAFEA;
display: flex;
justify-content: center;
align-items: center;
height: 100vh;
margin: 0;
}
/* Main container styling */
.container {
background-color: #ffffff;
box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
border-radius: 10px;
padding: 2em;
width: 350px;
text-align: center;
}
/* Header styling */
h2 {
color: #4a90e2;
margin-bottom: 0.5em;
}
/* Success message styling */
.success-message {
background-color: #e0f7e4;
color: #2e7d32;
padding: 0.5em;
border-radius: 5px;
margin-bottom: 1em;
}
/* Paragraph styling */
p {
color: #555;
font-size: 1em;
margin: 0.5em 0;
}
/* Button styling */
button {
background-color: #4a90e2;
color: #fff;
border: none;
border-radius: 5px;
padding: 0.8em 1.5em;
margin-top: 1em;
font-size: 1em;
cursor: pointer;
transition: background-color 0.3s ease;
width: 100%;
display: block;
}
/* Hover effect for buttons */
button:hover {
background-color: #357ab7;
}
/* Delete button specific styling */
.delete-button {
background-color: #e57373;
}
/* Hover effect for delete button */
.delete-button:hover {
background-color: #d32f2f;
}
</style>
</head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<div class="container">
<h2>
Welcome,
<%=((User) session.getAttribute("user")).getName()%>!
</h2>
<!-- Display success message -->
<%
String loginMessage = (String) session.getAttribute("loginSuccess");
if (loginMessage != null) {
%>
<p class="success-message"><%=loginMessage%></p>
<%
// Remove the message after displaying it once
session.removeAttribute("loginSuccess");
%>
<%
}
%>
<p>Your dashboard</p>
<form action="profile.jsp" method="get">
<button type="submit">View Profile</button>
</form>
<form action="update.jsp" method="get">
<button type="submit">Update Profile</button>
</form>
<form action="logout" method="post">
<button type="submit">Logout</button>
</form>
<!-- Delete Account Button -->
<form action="delete" method="post">
<button type="submit" class="delete-button">Delete Account</button>
</form>
</div>
</body>
</html>

