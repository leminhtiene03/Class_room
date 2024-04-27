<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PTIT EXAM</title>
    <link rel="stylesheet" href="./assests/css/main.css">
    <link rel="stylesheet" href="css/reset.css">
</head>
<body>
    <header>
      
        <p>Create/Edit Quiz</p>
    </header>

    <div class="container">
        <form id="quiz-form"  action="<%= request.getContextPath() %>/add_bt" method="post">
            <label for="quiz-name">Quiz Name:</label>
            <input type="text" id="quiz-name" name="quiz-name">

            <label for="quiz-description">Description:</label>
            <textarea id="quiz-description" name="quiz-description"></textarea>

            <label for="quiz-type">Quiz Type:</label>
            <select id="quiz-type" name="quiz-type">
                <option value="free">Free</option>
                <option value="specific-date">Specific Date</option>
            </select>
            
            <label for="quiz-time">Quiz Time:</label>
            <select id="quiz-time" name="quiz-time">
                <option value="5">5 phút</option>
                <option value="10">10 phút</option>
                <option value="15">15 phút</option>
                <option value="20">20 phút Date</option>
                <option value="30">30 phút</option>
                <option value="45">45 phút</option>
                <option value="60">60 phút</option>
                <option value="75">75 phút</option>
                <option value="100">100 phút</option>
                <option value="115">115 phút</option>
                <option value="130">130</option>
                
            </select>

            <div id="specific-date-container" style="display: none;">
                <label for="specific-date">Specific Date:</label>
                <input type="date" id="specific-date" name="specific-date">
                
                 <label for="specific-date">End Date:</label>
                <input type="date" id="end-date" name="end-date">
               
            </div>

            <h2>Questions</h2>
            <div id="questions-container">
                <!-- Questions will be dynamically added here -->
                 <label for="question">Question</label>
            <input type="text" name="question">

            <div class="answers">
                <label for="answer-a">A</label>
                <input type="text" name="answer-a">
                <br>
                <label for="answer-b">B</label>
                <input type="text" name="answer-b">
                <br>
                <label for="answer-c">C</label>
                <input type="text" name="answer-c">
                <br>
                <label for="answer-d">D</label>
                <input type="text" name="answer-d">
            </div>
a   
            <label id = "label_1"for="correct-answer">Correct Answer:</label>
            <select name="correct-answer">
                <option value="A">A</option>
                <option value="B">B</option>
                <option value="C">C</option>
                <option value="D">D</option>
            </select>
            <br>
            <button type="button" class="delete-question">Delete</button>
            </div>
        
            <button type="button" id="add-question">Add Question</button>
            <button  type="submit">SAVE</button>
        </form>
    </div>

    <script src="js/scripts.js"></script>
  
</body>
</html>
