<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login form</title>
   //<link rel="stylesheet" href="css/allmin.css"> 
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div id="top_bar">
        <i class="fa-solid fa-house"></i>
        <h4>PTIT EXAM</h4>
    </div>

    
<main>
        

        <form class="container" action="<%=request.getContextPath()%>/login" method="post" >
            <h1>Login </h1>
            <div class="container-text">
                <p>New to User? <a href="signup.jsp">Create an account</a> </p>
            </div>
            <div class="input-group">
                <label class="label-input" for="userEmailInp">Student ID / Username</label>
                <input class="input-style" id="userEmailInp" type="text" placeholder="B21DCCN704" name="useremail" required>
                <small id="smallElement" style="color: red;">${wrong_login}</small>
            </div>
            <div class="input-group">
                <label class="label-input" for="userpasswordInp">Password</label>
                <input class="input-style" id="userpasswordInp" type="password" name="userpassword" required>
                <small id="smallElementpassword" style="color: red;">${wrong_login}</small>
            </div>
            <div class="check-container">
                <div class="input-group">
                    <input id="userdata" style="cursor: pointer;" type="checkbox" name="useremail" value="Remember-me" checked required>
                    <label class="label-input" for="userdata">Remember me</label>
                </div> 
                <p><a href="#">Forgot your password?</a></p>
            </div>
            <div class="common-btn">
                <button id="loginBtn">Login</button>
            </div>
            <div class="other-login">
                <p>Or login with</p>
    
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
    </main>
    
    <script src="js/loginpage.js"></script>
   
</body>
</html>

