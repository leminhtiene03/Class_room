<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
   
    <title>PTIT EXAM</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/topbar.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/main_admin.css">
    
</head>
<body>
  
    <div id="left_part">
             
    
        <div class="second_mid">
            <ul id="second_mid_list">
                <li><a href="<%=request.getContextPath()%>/display"><i class="fa-solid fa-house"></i>Màn hình chính</a></li>
                <li><a href=""><i class="fa-regular fa-compass"></i>Lịch biểu</a></li>
                <li><a href=""><i class="fa-solid fa-music"></i>Nhắc nhở</a></li>
              
            </ul>
        </div>


        <div id="final_part">
            <ul id="final_part_list">
               <button class="" id="creat_new_class" onclick="touch()">  <i class="fa-solid fa-plus"></i>  Tạo lớp mới</button>  
                <li class = "final_part_li"><a href="">${notice}</a>  </li>
               
            </ul>
        </div>
    </div> 
  
   
    <div id="topbar">
        <div id="header">
            <ul id="header_bar">
               <li> <i id ="icon1"class="fa-solid fa-bars"></i></li>
               <li id="li_1"><img src="images/logo2.jpg" alt="" id="header_img"></li>
            </ul>
        </div> 
        <form id="input_top"  action="<%= request.getContextPath() %>/join_class"  method="post">
            <label for=""><i class="fa-solid fa-magnifying-glass"></i> </label>
            <input maxlength="50" placeholder="Gia nhập lớp ${join_class_result}"id="but_top" name="join_class_l"> 
             <button  id="que_ry" type="submit">Search</button>

        </form>
 
        <div id="query">
            <div id="results"></div>
            <div id="detailsModal" class="modal">
                <div class="modal-content">
                    <span onclick="close_search()" id="close">&times;</span>
                    <div id="detailResult"></div>
                </div>
            </div>
        </div>
       
<p></p>

        <a href="">  <i id="right_bar" class="fa-regular fa-share-from-square"></i> </a>
        <img onclick="close_drop()" src="images/logo3.jpg" alt="" id="top_img">
        <div id="menu_avatar">
            <div id="menu_avatar_top"> 
                <img src="images/logo3.jpg" alt="" id="ava1">
                <p>Le Minh Tien</p>
                <p>leminhtienpipt@gmail.com</p>
               <p><a href="">Quản lý tài khoản của bạn</a></p> 
            </di>
        </div>

        <div id="topbar_2">
            <ul>
                <li> <a href=""><i class="fa-solid fa-user-tie"></i>Kênh của bạn</a></li>
                <li><a href=""><i class="fa-solid fa-money-check-dollar"></i>Gói thành viên tính phí</a></li>
                <li> <a href=""><i class="fa-solid fa-users"></i>Chuyển đổi tài khoản</a></li>
                <li><a method="post" href="<%=request.getContextPath() %>/exit_login"><i class="fa-solid fa-right-from-bracket"></i> Đăng xuất</a></li>                  
            </ul>
        </div>

        <div id="topbar_3">
            <ul>
                <li> <a href=""><i class="fa-solid fa-user-tie"></i>Tải nhạc lên</a></li>
                <li><a href=""><i class="fa-solid fa-money-check-dollar"></i>Video đã xem</a></li>
                <li> <a href=""><i class="fa-solid fa-users"></i>Cài đặt</a></li>
                <li><a href=""><i class="fa-solid fa-right-from-bracket"></i> Điều khoản và chính sách</a></li>  
                <li> <a href=""><i class="fa-solid fa-users"></i>Trợ giúp</a></li>
                <li><a href=""><i class="fa-solid fa-right-from-bracket"></i> Phản hồi</a></li>  
                                
            </ul>
        </div>
    </div>
    </div>

   <main>
<h1 style="color :red;">${ notice_noclass}</h1>
<c:forEach var="classlist" items="${listClass}">



<div class="subject_box">
    <div id = "add_mi"class="option_block">
             <a href="delete?id=<c:out value='${classlist.id}' />">${exit_class}</a>  
    </div>
    <div class="top_box">
       
        <a href="exam_go?id=<c:out value='${classlist.id}' />" class="subject_name"> <c:out  value="${classlist.name}" /></a>
        <br>
        <a href=""  class="author_name"><c:out value="${classlist.author}" /></a>
    </div>
    <img src="images/ava.jpg" alt="" class="author_ava">
    <p class="descrire_subject"><c:out value="${classlist.description}" /></p>
     <p class="descrire_subject"><c:out value="${classlist.id}" /></p>
     <a href="edit?id=<c:out value='${classlist.id}' />"></a>
 	 
</div>


</c:forEach>


    <form id="add_class" action="<%= request.getContextPath() %>/insert" method="post">
        <i id ="close_form"class="fa-solid fa-xmark" onclick="close_creat()"></i>
        <h3>Tạo lớp mới</h3>
        <div class="box_add_Class">
            <label for="">Tên lớp</label>
            <input type="text" name = "class_name"> 
    
        </div>

    
        <div class="box_add_Class">
            <label for="">Mô tả</label>
            <textarea id="w3review" name="class_des" rows="4" cols="50"></textarea>
    
        </div>
        <button type ="submit">Tạo lớp</button>
    </form>

    <form id="fix_class">
        <i id ="close_form"class="fa-solid fa-xmark" onclick="close_creat()"></i>
        <h3>Sửa thông tin lớp</h3>
        <div class="box_add_Class">
            <label for="">Tên lớp</label>
            <input type="text" id = "class_name_change"> 
    
        </div>

    
        <div class="box_add_Class">
            <label for="">Mô tả</label>
            <textarea id="w3review" name="w3review" rows="4" cols="50"></textarea>
    
        </div>
        <button >Tạo lớp</button>
    </form>


   </main>
  
   <script src="https://kit.fontawesome.com/d542a4d4a5.js" crossorigin="anonymous"></script>
   <script src="js/main.js"></script>
  
</body>
 
</html>