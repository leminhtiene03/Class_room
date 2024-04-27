<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/all.min.css">
    <link rel="stylesheet" href="css/style.css">
    <title>PTIT EXAM</title>
</head>
<body>
    <div id="top_bar">
        <i class="fa-solid fa-house"></i>
        <h4>PTIT EXAM</h4>
    </div>

    <form class="container" action="<%= request.getContextPath() %>/register" method="post">
        <h1>Sign up to PTIT EXAM
        </h1>
        <div class="container-text">
            <p>Already have an account? <a href="login.jsp"> Log In</a> </p>
        </div>
        <div class="input-group">
            <label class="label-input" for="userEmailInp">Student ID or email</label>
            <input class="input-style" id="userEmailInp" type="text" placeholder="example@gmail.com" name="username" required>
            <small id="smallElement" style="color: red;"></small>
        </div>
        <div id="datacontainer" class="datacontainer">
            <div class="input-group">
                <label class="label-input" for="userFnameInp">First name</label>
                <input class="input-style" id="userFnameInp" type="text"  name="firstName" required>
                <small id="smallElementFname" style="color: red;"></small>
            </div>
            <div class="input-group">
                <label class="label-input" for="userLnameInp">Last name <small style="color:#B9BECE;">(optional)</small> </label>
                <input class="input-style" id="userLnameInp" type="text"  name="lastName" >
                <small id="smallElementLname" style="color: red;"></small>
            </div>
            <div class="input-group">
                <label class="label-input" for="userpasswordInp">Password</label>
                <input class="input-style" id="userpasswordInp" type="text" name="password" placeholder="Password must contain at least 8 characters" required>
                <small id="smallElementpassword" style="color: red;"></small>
            </div>
            <input type="checkbox" id="vehicle1" name="vehicle1" value="true">
            <label for="vehicle1"> I am teacher</label><br>
        </div>
        <div class="common-btn">
            <button id="Continuebtn">Continue</button>
        </div>
        <div class="other-login">
            <p>Or signup with</p>
        </div>
        <div class="social-medai">
            <div class="google">
                <span class="google-img"></span> 
                <p>google</p>
            </div>
            <div class="facebook">
                <span class="facebook-img"></span> 
                <p> facebook</p>
            </div>
            <div class="Office">
                <span class="Office-img"></span>
                <p> Office 365</p>
            </div>
        </div>
        <div id="more-social-medai" class="more-container">
            <div class="Clever" style="margin-right: 15px;">
                <span class="Clever-img"></span> 
                <p>Clever</p>
            </div>
            <div class="linkedin">
                <span class="linkedin-img"></span> 
                <p>linkedin</p>
            </div> 
        </div>
        <div class="show-more">
            <h4 id="show">More <i class="fas fa-chevron-down"></i></h4>
        </div>
    </form>
    <script src="js/signuppage.js"></script>
    <script src="https://kit.fontawesome.com/d542a4d4a5.js" crossorigin="anonymous"></script>
</body>
</html>

