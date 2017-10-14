<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amnesia</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="container">
		<div class="info">
			<h1>Set Alarm</h1>
		</div>
	</div>
	<div class="form">
		<form class="login-form" type="get" action="AddNumber" method="POST">
			<input type="text" name="name" id="name" placeholder="Name" /> <br>
			<input type="text" name="mobile" id="mobile"
				placeholder="Mobile with + and International code" /> <br>
			<button type="submit" value="Submit">Send Messages</button>
		</form>
	</div>
</body>
</html>