<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CARD AND PIN NUMBER</title>
<link rel="stylesheet" href="css/Style.css">
</head>
<body>
<div class="container">
<video src="images/pexels-rodnae-productions-5699998 (2160p).mp4" autoplay muted loop class="video"> </video>
	<div class="row">
		<div class="login-box">
			<h2>Generated Card and PIN Numbers:</h2>
  			  <p class="generate">Card Number: <%= session.getAttribute("cardNumber") %></p>
    		  <p class="generate">PIN Number: <%= session.getAttribute("pinNumber") %></p>
    
    			<a class="btn btn-info" id="button3" href="index.jsp">Back</a>
		</div>
	</div>
</div>
</body>
</html>