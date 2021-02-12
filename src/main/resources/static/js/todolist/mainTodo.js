$(document).ready(function(){

    $.ajax({
        url: "/restTodolist/getTodo",
        type: "get",
        success:function (data) {
            $.each(data, function(index, item){
                console.log(index+":"+item.todolist);
                $("#todo").append("<li class='itemList'><span onclick='doneTodo("+item.todolistId+")'><i class='fa fa-trash'></i></span> " + item.todolist + "</li>")

            });
        }
    })





    /*$("#todo").on("click", "li", function(){
        let doneTodo = {todolistId:$('#todo').val()};
        console.log(doneTodo);
         $(this).toggleClass("completed");
        $.ajax({
            url: "/restTodolist/doneTodo",
            type: "get",
            data: doneTodo,
            contentType: "application/text",
            success:function (data) {
                console.log("todo적용쓰"+data);
                $(this).toggleClass("completed");
            },error: function (data) {
                console.log("실패"+data);
            }
        })
    });*/


    $("#todo").on("click", "span", function(event){
        $(this).parent().fadeOut(500,function(){
            $(this).remove();
        });
        event.stopPropagation();
    });

    $('#addTodo').keypress(function(event){
        if(event.which === 13){
            alert("enter");
            let addTodo ={todolist: $('#addTodo').val()};
            console.log('addTodo',addTodo);
            //$('#addTodo').val();
            $.ajax({
                url: "/restTodolist/addTodo",
                type: "POST",
                //dataType : "json",
                data:JSON.stringify(addTodo),
                contentType: "application/json",
                success:function (data) {
                    console.log("todo적용쓰"+data);
                    $('#todo').append("<li class='itemList'><span><i class='fa fa-trash'></i></span> " + $('#addTodo').val() + "</li>")
                    $("#addTodo").val("");
                },error: function (data) {
                    console.log("실패"+data);
                }
            })
        }
    });


    /*$(".fa-plus").click(function(){
        $("#addTodo").fadeIn();
    });*/


    $(".todolist").click(function(){
        $(".todo").fadeToggle();
    });

});

function doneTodo(id){
    let todoData = {todolistId:id};
    console.log(todoData);
    $(this).toggleClass("completed");
    $.ajax({
        url: "/restTodolist/doneTodo",
        type: "get",
        data: todoData,
        contentType: "application/text",
        success:function (data) {
            console.log("todo적용쓰"+data);
            $(this).toggleClass("completed");
        },error: function (data) {
            console.log("실패"+data);
        }
    })
}

/*$(function (){
    $(".itemList").hover(function (){
        console.log("hover걸렸어?");
        $(".trash").css({
            width:"40px",
            opacity:"1.0"
        },function () {
            $(".trash").css({
                width: "0",
                opacity: "0"
            })
        });
    })
})*/
/*
.itemList:hover .trash {
    width: 40px;
    opacity: 1.0
}*/
