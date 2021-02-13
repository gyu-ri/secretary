$(document).ready(function(){

    $(".todolist").click(function(){
        $(".todo").fadeToggle();
    });

    $.ajax({
        url: "/restTodolist/getTodo",
        type: "get",
        success:function (data) {
            $.each(data, function(index, item){
                if(item.finishStatus==1){
                    $("#todo").append("<li class='completed' name='itemList' id='"+item.todolistId+"' onclick='doneTodo("+item.todolistId+")'><span class='trash' onclick='deleteTodo("+item.todolistId+")'><i class='fa fa-trash'></i></span> " + item.todolist + "</li>")
                }else{
                    $("#todo").append("<li name='itemList' id='"+item.todolistId+"' onclick='doneTodo("+item.todolistId+")'><span class='trash' onclick='deleteTodo("+item.todolistId+")'><i class='fa fa-trash'></i></span> " + item.todolist + "</li>")
                }

            });
        }
    })

    $('#addTodo').keypress(function(event){
        if(event.which === 13){
            let addTodo ={todolist: $('#addTodo').val()};
            console.log('addTodo',addTodo);
            //$('#addTodo').val();
            $.ajax({
                url: "/restTodolist/addTodo",
                type: "POST",
                //dataType : "json",
                data:JSON.stringify(addTodo),
                contentType: "application/json",
                success:function (item) {
                    $('#todo').append("<li name='itemList' id='"+item.todolistId+"' onclick='doneTodo("+item.todolistId+")'><span class='trash' onclick='deleteTodo("+item.todolistId+")'><i class='fa fa-trash'></i></span> " + item.todolist + "</li>")
                    $("#addTodo").val("");
                },error: function (data) {
                    console.log("실패"+data);
                }
            })
        }
    });
});

function doneTodo(id){
    let todoData = {todolistId:id};
    if($("li[id="+id+"]").hasClass("completed")){
        $.ajax({
            url: "/restTodolist/undoTodo",
            type: "get",
            data: todoData,
            contentType: "application/text",
            success:function (data) {
                console.log("todo적용쓰"+data);
                $("li[id="+id+"]").toggleClass("completed");
            },error: function (data) {
                console.log("실패"+data);
            }
        })
    }else{
        $.ajax({
            url: "/restTodolist/doneTodo",
            type: "get",
            data: todoData,
            contentType: "application/text",
            success:function (data) {
                console.log("todo적용쓰"+data);
                $("li[id="+id+"]").toggleClass("completed");
            },error: function (data) {
                console.log("실패"+data);
            }
        })
    }
}

function deleteTodo(id){
    let todoData = {todolistId:id};
    console.log(todoData);
    $.ajax({
        url: "/restTodolist/deleteTodo",
        type: "get",
        data: todoData,
        contentType: "application/text",
        success:function (data) {
            console.log("deletetodo적용"+data);
            $("li[id="+id+"]").fadeOut(500,function(){
                $("li[id="+id+"]").remove();
            });
        },error: function (data) {
            console.log("실패"+data);
        }
    })
}