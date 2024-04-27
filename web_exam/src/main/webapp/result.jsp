<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/do_exam.css">
<link rel="stylesheet" href="css/reset.css">
</head>
<body>
 <div id="top_bar">
        <p>  Bài thi </p>
    </div>

    <form id="infor" action="<%= request.getContextPath() %>/do_exam" method="post">
     <label style="width: 200px;color:red;" for="">Kết quả bài thi </label>  <br>
        <label for="">Tên bài thi </label> <p>${in4_exam.name}</p><br>
         <label for="">Số câu làm được </label>   <p>${answer_All}</p> <span>/</span> <p>${ num_question}</p> <br>  
         <label for="">Điểm số </label>   <p>${point}</p>
         
       
    		 
    </form>
    <main>
      
      
        <div id="container_exam">
            <h2>Bài làm</h2>
            <form action="<%= request.getContextPath() %>/get_result" method="post"" method="post" >
           
               <c:forEach var="list_question" items="${list_question}">
               
                <div class="question">
                    <p>Câu hỏi ${ list_question.num} :  ${ list_question.question}</p>
                    <div class="options">
                      <input type="radio" name="${list_question.num}" value ="A">  <label> ${ list_question.answer_a}</label>
                 		 <input type="radio" name="${list_question.num}" value ="B">  <label> ${ list_question.answer_b}</label>
                       <input type="radio" name="${list_question.num}"  value ="C">  <label> ${ list_question.answer_c}</label>
                      <input type="radio" name="${list_question.num}" value ="D">  <label> ${ list_question.answer_d}</label>
                    </div>
                                         <div id="answer">
                        <p id="">Trả lời :</p> <p>${list_question.user_answer}</p>
                        <p id="">Đáp án :</p> <p>${list_question.right_answer}</p>
                    </div>
                </div>
   				 </c:forEach>
   				
                

                <button style="width:200px"type="submit"><a>Báo cáo </a></button>
                 <button style="width:200px"type="submit"><a style="color:white;text-decoration: none;"  href="<%=request.getContextPath()%>/result_exam">Về trang chủ</a></button>
            </form>
        </div>
      
    </main>
    <script src="css/do_exam.js"></script>
</body>
</html>