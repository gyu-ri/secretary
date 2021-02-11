$(document).ready(function(){

    $.ajax({
        url: "/restTodolist/getTodo",
        type: "get",
        success:function (data) {
            $.each(data, function(index, item){
                console.log(index+":"+item.todolist);
                $("#todo").append("<li><span><i class='fa fa-trash'></i></span> " + item.todolist + "</li>")
            });
        }
    })


    $("#todo").on("click", "li", function(){
        $(this).toggleClass("completed");
        $.ajax({
            url: "/restTodolist/updateTodo",
            type: "get",
            success:function (data) {
                console.log("todo적용쓰"+data);
            },error: function (data) {
                console.log("실패"+data);
            }
        })
    });


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
            // $('#addTodo').val("");
            $.ajax({
                url: "/restTodolist/addTodo",
                type: "POST",
                //dataType : "json",
                //data : $('#addTodo').val(),
                //data : {addTodo:addTodo},
                data:JSON.stringify(addTodo),
                contentType: "application/json",
                success:function (data) {
                    console.log("todo적용쓰"+data);
                    $('#todo').append("<li><span><i class='fa fa-trash'></i></span> " + $('#addTodo').val() + "</li>")
                },error: function (data) {
                    console.log("실패"+data);
                }
            })
             // $("ul").append("<li><span><i class='fa fa-trash'></i></span> " + addTodo + "</li>")
        }
    });


    $(".fa-plus").click(function(){
        $("#addTodo").fadeToggle();
    });

});