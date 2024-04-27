
let  creat = document.getElementById("add_class");
let fix = document.getElementById("fix_class");
function touch()
{
  
    creat.style.display = "block";


}
let close = document.getElementById("close_form");

function close_creat()
{
   creat.style.display = "none";
   fix.style.display ="none";
}

let open_ava = document.getElementById("menu_avatar");
function close_drop(){
    if ( open_ava.style.display === 'none')
    {
        open_ava.style.display = 'block';
    }
    else open_ava.style.display = "none";
}

let open_option_box = document.getElementById("add_more");
function drop_Dowm(){
    if ( open_option_box.style.display === 'none')
    {
        open_option_box.style.display = 'block';
    }
    else open_option_box.style.display = "none";
}

let element_work = document.getElementById("content_subject");
let change_part = document.getElementById("content_people");

let list=document.getElementById("list_point");
 document.onload = function change_part_ele(){
   
        change_part.style.display ="block";
        element_work.style.display = "none";
        detail.style.display="none";
        list.style.display="none";
    
        if ( change_part.style.display === 'none')
    {
        change_part.style.display = 'block';
    }
    
}

  window.onload = () => {
	 if ( change_part.style.display === 'none' && change_part.style.display =="none" )
    {
        change_part.style.display = 'block';
    }
  }
function change_part_ele2(){
    
   
        change_part.style.display = "none";
        element_work.style.display ="block";
        detail.style.display="none";
        list.style.display="none";
    
    
}
let detail =document.getElementById("content_detail");
function show_detail(){
    
        change_part.style.display = "none";
        element_work.style.display ="none";
        detail.style.display="block";
        list.style.display="none";
    
}
function show_list(){
    
        change_part.style.display = "none";
        element_work.style.display ="none";
        detail.style.display="none";
        list.style.display="block";
    
}
let add_more_option = document.getElementById("menu_option");
function list_Admin(){
    
    if ( add_more_option.style.display === 'none')
    {
        
        add_more_option.style.display ="block";
    }
    else add_more_option.style.display='none';
    
}
let delete_sutdent = document.getElementById("student_option");
function config_student(){
    if ( delete_sutdent.style.display === 'none')
    {
        
        delete_sutdent.style.display ="block";
    }
    else delete_sutdent.style.display='none';
}


let lost = document.getElementById("add_mi");
function option_block_open(){

    if ( lost.style.display === 'none')
    {
        
        lost.style.display ="block";
    }
    else lost.style.display='none';
}
let fix_class = document.getElementById("fix_class");
let option_box_dele = document.getElementById("add_mi");
function change_i4 (){
    option_box_dele.style.display ="none";
    fix_class.style.display = "block";
}
