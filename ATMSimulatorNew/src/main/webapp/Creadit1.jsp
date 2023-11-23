<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CREADITING THE AMOUNT</title>
<link rel="stylesheet" href="css/Style.css">
</head>
<body>
<div class="container">
 <video src="images/pexels-rodnae-productions-5699998 (2160p).mp4" autoplay muted loop class="video"> </video>
	<div class="row">
		<div class="login-box">
		<form action="CreaditSec1" method="post" class="Login1">
		<h2>ENTER AMOUNT YOU WANT TO CREDIT !!!</h2>
		<div class="user-box">
			<input type="text" name="card1" placeholder="Enter the card Number">
		</div><br>
		<div class="user-box">
			<input type="text" name="creadit1" placeholder="Enter the Amount">
		</div><br>
			<div class="buttons">
			<button class="btn btn-secondary" id="button3" type="reset">Clear</button>
			<button class="btn btn-success" id="button3" type="submit">Submit</button>
			<a class="btn btn-info" id="btn1" href="Main.jsp">Back</a>
			</div>
		</form>
		</div>
	</div>
</div>
</body>
</html>