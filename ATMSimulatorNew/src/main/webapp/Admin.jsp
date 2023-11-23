<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CREATING ACCOUNT OF BANK</title>
<link rel="stylesheet" href="css/Style3.css">
</head>
<body>
    <div class="container form">
    <video class="video" src="images/pexels-rodnae-productions-7821854 (1080p).mp4" autoplay muted loop></video>
        <div class="row">
            <div class="login-form">
                <h1 class="title">Register</h1>
                <h2 class="message">Welcome To The Admin Section</h2>
                <form method="post" action="CardPinGeneratorServlet" class="login">
                    <!--                     <label for="">Card No. :</label><input type="number" name="input1" placeholder="Enter Your Card Number"><br>
                    <label for="">Pin :</label><input type="password" name="input2" placeholder="Enter Your Pin"><br> -->
                    <label for="input1">Name :<input class="input" required="" type="text" name="input1" placeholder="">
                        <span>Enter Your Name</span> </label><br>
                    <label for="input2">Age :<input class="input" type="text" required="" name="input2"
                            placeholder=""> <span>Enter Your Age</span></label><br>
                    <label for="input3">Mobile No :<input class="input" type="text" required="" name="input3"
                            placeholder=""><span>Enter Your Phone Number</span></label><br>
                    <label for="input4">Aadhar No :<input class="input" type="text" required="" name="input4"
                            placeholder=""><span>Enter Your Aadhar Card Number</span></label><br>
                    <label for="input5">Pan No :<input class="input" type="text" required="" name="input5"
                            placeholder=""><span>Enter Your Pan Number</span></label><br>
                    <label for="input6">Account Type :
                        <select class="input" name="input6">
                            <option value="Savings">Savings </option>
                            <option value="Current">Current </option>
                            <option value="Buisness">Buisness </option>
                        </select>
                    </label><br>
                    <label for="input7">Add Amount :<input class="input" type="number" required="" name="input7"
                            placeholder=""><span>Enter Your Want To add</span></label><br>
                    <label for="input8">Address :<input class="input" type="text" required="" name="input8"
                            placeholder=""><span>Enter Your Address</span></label><br>
                    <a class="submit" href="AdminSec.jsp">Back</a>
                    <button class="submit" type="submit">Submit</button>
                    <button class="submit" type="reset">Reset</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>