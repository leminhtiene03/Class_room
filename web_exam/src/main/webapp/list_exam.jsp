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
    
   
    <link rel="stylesheet" href="css/topbar.css">
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/listbaitap.css">
    <link rel="stylesheet" href="css/admin_listbt.css">
    <link rel="stylesheet" href="css/baithidetail.css">
    <link rel="stylesheet" href="css/thongke.css">
</head>
<body>
  
    <div id="left_part">
             
    
        <div class="second_mid">
            <ul id="second_mid_list">
                <li><a href="main_ad.jsp"><i class="fa-solid fa-house"></i>Màn hình chính</a></li>
                <li><a href=""><i class="fa-regular fa-compass"></i>Lịch biểu</a></li>
                <li><a href=""><i class="fa-solid fa-music"></i>Nhắc nhở</a></li>
              
            </ul>
        </div>


        <div id="final_part">
            <ul id="final_part_list">
               <button onclick="touch()">  <i class="fa-solid fa-plus"></i> Tạo lớp mới</button>  
                <li class = "final_part_li"><a href="">Mạng máy tính</a>  </li>
                <li class = "final_part_li"><a href="">Công nghệ phần mềm </a>      </li>
                <li class = "final_part_li"><a href="">CSDL Phân tán</a>    </li>
                <li class = "final_part_li"><a href="">Lập trình web  </a>      </li> 
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
        <div id="input_top">
            <label for=""><i class="fa-solid fa-magnifying-glass"></i></label>
            <input maxlength="50" placeholder="Tìm tên bài tập, môn học"id="but_top"></input> 
        </div>

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
                <li> <a href=""><i class="fa-solid fa-user-tie"></i>Các lớp của bạn</a></li>
                <li><a href=""><i class="fa-solid fa-money-check-dollar"></i>Gói thành viên tính phí</a></li>
                <li> <a href=""><i class="fa-solid fa-users"></i>Chuyển đổi tài khoản</a></li>
                <li><a href="login.jsp"><i class="fa-solid fa-right-from-bracket"></i> Đăng xuất</a></li>                  
            </ul>
        </div>

        <div id="topbar_3">
            <ul>
                <li> <a href=""><i class="fa-solid fa-user-tie"></i>Tải file lên</a></li>
                <li><a href=""><i class="fa-solid fa-money-check-dollar"></i>Lớp đã tạo</a></li>
                <li> <a href=""><i class="fa-solid fa-users"></i>Cài đặt</a></li>
                <li><a href=""><i class="fa-solid fa-right-from-bracket"></i> Điều khoản và chính sách</a></li>  
                <li> <a href=""><i class="fa-solid fa-users"></i>Trợ giúp</a></li>
                <li><a href=""><i class="fa-solid fa-right-from-bracket"></i> Phản hồi</a></li>  
                                
            </ul>
        </div>
    </div>
    </div>

   <main>

    <div id="top_main_ele">
    <div class="ok">
        <a onclick="change_part_ele2()" href="<%=request.getContextPath()%>/exam_go" >Bảng tin</a>
         </div>
          <div class="ok">
        <a onclick="change_part_ele()" href="<%=request.getContextPath()%>/people_list">Mọi Người</a>
         </div>
           <div class="ok">
       <a onclick="show_list()">Thống kê</a>
        </div>
       
    </div>
    <div id="class_name">
        <p>Danh sách môn học</p>
        <a href="add_question.jsp">
            <i class="fa-solid fa-plus"></i>
            <p id="p2">Thêm bài thi</p>
        </a>
        
        
       

    </div>

    <div id="content_subject">
        <ul>
        
        <c:forEach var="classlist" items="${listClass}">
        
            <li onclick="show_detail()" ><i  class="fa-regular fa-file"></i>
         
         		 <a onclick="show_detail()" class="subject_name" href="description?id2=<c:out value='${classlist.id}' />"> <c:out  value="${classlist.name}" /></a>
              
        
               <a class = "delete_exam" href="delete_exam?id3=<c:out value='${classlist.id}' />"> Xóa</a>
               
            </li>
            
       </c:forEach>
        </ul>
    </div>
    <div id="content_people">
        <ul>
           <c:forEach var="list_GV" items="${all_teacher}">
            <p>${Giangvien}</p>
            
            <li><img src="images/ava.jpg" alt="">
            
                <a href="">${list_GV.fullname}</a>
                <a>${list_GV.email}</a>
               
            </li>
           	</c:forEach>
            <p>${Hocsinh}</p>
             <c:forEach var="list_student" items="${List_Student}">
            <li><img src="images/ava.jpg" alt="">
                <a href=""><c:out  value="${list_student.fullname}" /></a>
                <a><c:out  value="${list_student.email}" /> </a>
                
                <i onclick="config_student()" class="fa-solid fa-ellipsis-vertical"></i>
                <div id="student_option">
                    <p>Xem thông tin</p>
                    <p>Xóa học sinh</p>
                   
                </div>
            </li>
 			</c:forEach>
          
            
        </ul>
    </div>
     
      
    <div id="content_detail">
   <c:forEach var="desslist" items="${listDes}">
        <div id="content_detail_left">
            <div id="top_name">
                <i class="fa-solid fa-file"></i>
            <h2><c:out value="${desslist.exam_name}" /></h2>
            </div>
            <div id="content_left_below">
                <p id="content_author"><c:out value="${desslist.class_ID}" /></p>
               <div id="time_line">
                <p id="start"><c:out value="${desslist.exam_date}" /></p>
                <p id ="end"><c:out value="${desslist.description}" /> </p>
               </div>
               <span></span>
                <p id="content_notice"><c:out value="${desslist.exam_date_end}" /> <br>
                   
                </p>

                <div id="content_file">
                    <a href="file/Tài-liệu-7.docx">Tài liệu tham khảo</a>
                    <a href=""></a>
                    <a href=""></a><a href=""></a>
                  
                   
                </div>
                
            </div>
        
        </div>
        <form id="content_right" action="<%= request.getContextPath() %>/get_in_exam" method="post">
            <div id="bar_right">
                <label>Trạng thái bài thi</label> <p>Trong thời hạn</p>
            </div>
            <div id="bar_right">
                <label>Hoàn thành</label> <p>Chưa</p>
            </div> 
               <button type = "submit">  Bắt đầu làm bài thi</button>
        </form>
           </c:forEach>
    </div>
    
     
    <div id="list_point">
        <div id="customTable">
            <div id="filter">
                <label for="customExam">Select Exam:</label>
                <select id="customExam" onchange="filterCustomTable()">
                    <option value="exam1">Exam 1</option>
                    <option value="exam2">Exam 2</option>
                    <option value="exam3">Exam 3</option>
                </select>
            </div>
            <div id="examInfo">
                <!-- Exam information will be loaded dynamically here -->
            </div>
            <div id="customTableContent">
                <!-- Custom table content will be loaded dynamically here -->
            </div>
        </div>
        
        <div id="filterCustomTable">
            <label>Filter Custom Table</label>
            <div id="filterOptions">
                <label for="filterName">Filter by Name:</label>
                <input type="text" id="filterName" oninput="filterCustomTable()">
            </div>
            <div id="filterAttendances">
                <label for="filterAttendances">Filter by Attendances:</label>
                <select id="filterAttendancesSelect" onchange="filterCustomTable()">
                    <option value="">All</option>
                    <option value="3">Less than 3</option>
                    <option value="4">3-4</option>
                    <option value="5">5 or more</option>
                </select>
            </div>
            <div id="filterStartDate">
                <label for="startDate">Filter by Start Date:</label>
                <input type="date" id="startDate">
               
            </div>
            <div id="filterCompletionRate">
                <label for="completionRate">Filter by Completion Rate:</label>
                <select id="completionRate" onchange="filterCustomTable()">
                    <option value="">All</option>
                    <option value="100%">100%</option>
                    <option value="90%">90%</option>
                    <option value="80%">80%</option>
                    <!-- Add more options as needed -->
                </select>
                
            </div>
           
        </div> 
        
    </div>
 


    <form id="add_class">
        <i id ="close_form"class="fa-solid fa-xmark" onclick="close_creat()"></i>
        <h3>Tạo lớp mới</h3>
        <div class="box_add_Class">
            <label for="">Tên lớp</label>
            <input type="text"> 
    
        </div>

    
        <div class="box_add_Class">
            <label for="">Mô tả</label>
            <textarea id="w3review" name="w3review" rows="4" cols="50"></textarea>
    
        </div>
        <button>Tạo lớp</button>
    </form>

    <!-- <form id="add_class">
        <i class="fa-solid fa-xmark"></i>
        <h3>Tạo kì thi mới</h3>
        <div class="box_add_Class">
            <label for="">Tên kì thi</label>
            <input type="text"> 
        </div> 
        <div class="box_add_Class">
            <label for="">Thời hạn bắt đầu</label>
            <input type="date"> 
    
        </div>
        <div class="box_add_Class">
            <label for="">Thời hạn hoàn thành</label>
            <input type="date"> 
    
        </div>
        <div class="box_add_Class">
            <label for="">Thời gian làm bài</label>
            <input type="text" id="time_choose"> 
            <label for="">Phút</label>
    
        </div>

    
        <div class="box_add_Class">
            <label for="">Mô tả</label>
            <textarea id="w3review" name="w3review" rows="4" cols="50"></textarea>
    
        </div>
        <button>Tạo kì thi</button>
    </form> -->

   </main>
   
    <script src="js/main.js"></script>
    <script src="js/thongke.js"></script>
    <script src="https://kit.fontawesome.com/d542a4d4a5.js" crossorigin="anonymous"></script>
</body>
</html>