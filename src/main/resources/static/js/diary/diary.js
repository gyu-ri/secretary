let startNumber = 0;
let endNumber = 12;
let condition = 0;
$(function(){

    $("#deleteBtn").on("click", function(){

        $.ajax({
            url : "/restDiary/binDiaryList",
            type : "GET",
            data : {userId:$("#userId").val()},
            success: function (list){
                console.log(list);
                $("div [name='listSet']").remove();
                $("div [name='listSet']").remove();
                document.getElementById('fisrtTab').setAttribute('class', '');
                document.getElementById('secondTab').setAttribute('class', '');
                document.getElementById('thirdTab').setAttribute('class', '');
                document.getElementById('deleteBtn').setAttribute('class', 'active');

                $.each(list.reverse(),function(i,item){
                    console.log(item);
                    if (item.imageName!=null) {
                        $(".listDiary").append(
                            "<div id='"+item.diaryId+"' name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url("+item.imageName+"); background-repeat:no-repeat; background-size: cover;\">" +
                            // "<input type=\"text\" class=\"diaryText\"  value=\"" + item.diaryText +"\" hidden style=\"position: absolute\">" +
                            "<div class='cover'>" +
                            "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i onclick=\"deleteDiary("+item.diaryId+")\" class='fas fa-trash-alt'></i></a><a href='#'><i class='fas fa-trash-restore' onclick=\"recoverDiary("+item.diaryId+")\"></i></a></div>" +
                            "</div>" +
                            "</div>"+
                            "</div>"
                        )
                    }else{
                        $(".listDiary").append(
                            "<div id='"+item.diaryId+"' name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                            // "<input type=\"text\" class=\"diaryText\"  value=\"" + item.diaryText +"\" hidden style=\"position: absolute\">" +
                            "<div class='cover'>" +
                            "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i onclick=\"deleteDiary("+item.diaryId+")\" class='fas fa-trash-alt'></i></a><a href='#'><i class='fas fa-trash-restore' onclick=\"recoverDiary("+item.diaryId+")\"></i></a></div>" +
                            "</div>" +

                            "</div>"+
                            "</div>"

                        )
                    }

                })
            }
        });
    });



    // $(".deleteUnactive").on("click", function (){
    //     $('.deleteActive').hide();
    //     $('#deleteDiary').hide();
    //     $('.deleteUnactive').hide();
    // })

    $('#addDiaryNavi').on("click", function (){
        window.location.href="/diary/addDiary";
    })

    $("#getDiaryList").click(function(){
        condition = 0;
        startNumber = 0;
        endNumber = 12;
        $.ajax({
            url : "/restDiary/getDiaryList",
            type : "GET",
            data :{
                userId:$("#userId").val(),
                startNum:startNumber,
                endNum:endNumber
            },
            contentType : "application/json",
            success: function (list){
                console.log(list);

                $("div [name='listSet']").remove();
                document.getElementById('fisrtTab').setAttribute('class', 'active');
                document.getElementById('secondTab').setAttribute('class', '');
                document.getElementById('thirdTab').setAttribute('class', '');
                document.getElementById('deleteBtn').setAttribute('class', '');
                $.each(list,function(i,item){
                    console.log(item);
                    if (item.imageName!=null) {
                        $(".listDiary").append(
                            "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url("+item.imageName+"); background-repeat:no-repeat; background-size: cover;\">" +
                            // "<input type=\"text\" class=\"diaryText\"  value='" + item.diaryText + "' hidden style=\"position: absolute\">" +
                            "<div class='cover'>" +
                            "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i onclick=\"moveToBin("+item.diaryId+")\" class='fas fa-trash-alt'></i></a></div>" +
                            "</div>" +
                            "</div>"+
                            "</div>"
                        )
                    }else{
                        $(".listDiary").append(
                            "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                            // "<input type=\"text\" class=\"diaryText\"  value='" + item.diaryText +"' hidden style=\"position: absolute\">" +
                            "<div class='cover'>" +
                            "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i onclick=\"moveToBin("+item.diaryId+")\" class='fas fa-trash-alt'></i></a></div>" +
                            "</div>" +
                            "</div>"+
                            "</div>"

                        )
                    }
                })
            }
        });
    })

    $("#getOthersDiaryList").on("click", function () {
        var list = [];
        condition = 1;
        startNumber = 0;
        endNumber = 12;
        $.ajax({
            url: "/restDiary/getOthersDiaryList",
            method: "get",
            dataType: "json",
            data : {
                userId:$("#userId").val(),
                startNum:startNumber,
                endNum:endNumber},
            headers: { //excess 제어요청 헤더, n : v 형식으로 헤더 추가하면 url의 request header에서 해당 헤더로 값을 얻어올 수 있다.
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            success: function (list){
                console.log(list);
                $("div [name='listSet']").remove();
                document.getElementById('fisrtTab').setAttribute('class', '');
                document.getElementById('secondTab').setAttribute('class', '');
                document.getElementById('deleteBtn').setAttribute('class', '');
                document.getElementById('thirdTab').setAttribute('class', 'active');
                $.each(list,function(i,item){
                    console.log(item);
                    if (item.imageName!=null) {
                        $(".listDiary").append(
                            "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url("+item.imageName+"); background-repeat:no-repeat; background-size: cover;\">" +
                            // "<input type='hidden' class=\"diaryText\"  value=\"" + item.diaryText +"\" hidden style=\"position: absolute\">" +
                            "<div class='cover'>" +
                            "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'></div>" +
                            "</div>" +
                            "</div>"+
                            "</div>"
                        )
                    }else{
                        $(".listDiary").append(
                            "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                            // "<input type='hidden' class=\"diaryText\"  value=\"" + item.diaryText +"\" hidden style=\"position: absolute\">" +
                            "<div class='cover'>" +
                            "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'></div>" +
                            "</div>" +
                            "</div>"+
                            "</div>"
                        )
                    }

                })
            }
            //     )$("#for").prepend(
            //         "<div class='block' th:each='"+list+"' style='float: left'> " +
            //         "<p>" +
            //         "<input type='checkbox' class='deleteActive' name='deleteActive' id='deleteActive' th:value='${diary.diaryId}' style='float: left' hidden/>" +
            //         "<input type='hidden' name='diaryId' th:value='${diary.diaryId}'/>" +
            //         "제목 : <span th:text='${diary.diaryTitle}'>제목</span><br>" +
            //         "날짜 : <span th:text='${diary.diaryDate}'>날짜</span><br>" +
            //         "날씨 :  <img th:src='${diary.weather}' width='20' height='20'/><br>" +
            //         "위치 : <span th:text='${diary.location}'>위치</span>" +
            //         "</p>" +
            //         "</div>"
            // }
        });
        return list;
    });

    $('#deleteDiary').click(function (){
        var confirm_val = confirm("정말 삭제하시겠습니까?");

        if(confirm_val){

            var checkArr = [];
            $("input[name=deleteActive]:checked").each(function (i){
                checkArr.push($(this).val());
            });
            $.ajax({
                url : "/restDiary/moveToBin",
                type : "POST",
                data : JSON.stringify(checkArr),
                contentType : "application/json",
                success: function (list){
                    console.log(list);
                    $("div [name='listSet']").remove();
                    $.each(list,function(i,item){
                        console.log(item);
                        if (item.imageName!=null) {
                            $(".listDiary").append(
                                "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                                "<div class='box' style=\"background-image:url("+item.imageName+"); background-repeat:no-repeat; background-size: cover;\">" +
                                // "<input type=\"text\" class=\"diaryText\"  value=\"" + item.diaryText +"\" hidden style=\"position: absolute\">" +
                                "<div class='cover'>" +
                                "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                                "<p class='title'>"+item.diaryDate+"</p>" +
                                "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                                "<div class='social'></div>" +
                                "</div>" +
                                "</div>"+
                                "</div>"
                            )
                        }else{
                            $(".listDiary").append(
                                "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                                "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                                // "<input type=\"text\" class=\"diaryText\"  value=\"" + item.diaryText +"\" hidden style=\"position: absolute\">" +
                                "<div class='cover'>" +
                                "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                                "<p class='title'>"+item.diaryDate+"</p>" +
                                "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                                "<div class='social'></div>" +
                                "</div>" +
                                "</div>"+
                                "</div>"

                            )
                        }

                    })
                }
            });
        }
    });

    $("#getTagDiaryList").on("click", function () {
        var list = [];
        condition = 2;
        $.ajax({
            url: "/restDiary/getTagDiaryList",
            method: "get",
            dataType: "json",
            data : {userId:$("#userId").val()},
            headers: { //excess 제어요청 헤더, n : v 형식으로 헤더 추가하면 url의 request header에서 해당 헤더로 값을 얻어올 수 있다.
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            success: function (list){
                console.log(list);
                $("div [name='listSet']").remove();
                document.getElementById('fisrtTab').setAttribute('class', '');
                document.getElementById('secondTab').setAttribute('class', 'active');
                document.getElementById('deleteBtn').setAttribute('class', '');
                document.getElementById('thirdTab').setAttribute('class', '');
                $.each(list,function(i,item){
                    console.log(item);

                        $(".listDiary").append(
                            "<div name=\"listSet\" id='thisTag' value='"+item.fileName+"' class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                            // "<input type=\"text\" class=\"diaryText\"  value=\"" + item.fileName +"\" hidden style=\"position: absolute\">" +
                            "<div class='cover'>" +
                            "<h3 class='name'>#"+item.fileName+"</h3>" +
                            "</div>" +
                            "</div>"+
                            "</div>"
                        )

                })
            }
        });
        return list;
    });

    $(document).on("click","#thisTag", function (){
        $.ajax({
            url: "/restDiary/getTagedList",
            method: "GET",
            dataType: "json",
            data: {tag: $(this).attr('value')},
            contentType: "application/json",
            success: function(list){
                console.log(list);
                $("div [name='listSet']").remove();
                $.each(list.reverse(),function(i,item) {
                    if (item.imageName!=null) {
                        $(".listDiary").append(
                            "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url("+item.imageName+"); background-repeat:no-repeat; background-size: cover;\">" +
                            // "<input type=\"text\" class=\"diaryText\"  value=\"" + item.diaryText +"\" hidden style=\"position: absolute\">" +
                            "<div class='cover'>" +
                            "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i onclick=\"moveToBin("+item.diaryId+")\" class='fas fa-trash-alt'></i></a></div>" +
                            "</div>" +
                            "</div>"+
                            "</div>"
                        )
                    }else{
                        $(".listDiary").append(
                            "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                            // "<input type=\"text\" class=\"diaryText\"  value=\"" + item.diaryText +"\" hidden style=\"position: absolute\">" +
                            "<div class='cover'>" +
                            "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i onclick=\"moveToBin("+item.diaryId+")\" class='fas fa-trash-alt'></i></a></div>" +
                            "</div>" +
                            "</div>"+
                            "</div>"

                        )
                    }

                })
            }
        });

    });

})



// $(document).ready(function() {
//     $('.tabs .tab-links a').on('click', function(e) {
//         var currentAttrValue = jQuery(this).attr('href');
//         // Show/Hide Tabs
//         $('.tabs ' + currentAttrValue).show().siblings().hide();
//
//         // Change/remove current tab to active
//         $(this).parent('li').addClass('active').siblings().removeClass('active');
//
//         e.preventDefault();
//     });
// });

function filter(){
    var value, name, item, i;
    value = document.getElementById("value").value.toUpperCase();
    item = document.getElementsByClassName("col-md-4");

    for(i=0; i< item.length; i++){
        name = item[i].getElementsByClassName('diaryText');
        if(name[0].value.toUpperCase().indexOf(value) > -1){
            item[i].style.display = "block";
        }else{
            item[i].style.display = "none";
        }
    }
}

function deleteDiary(diaryId){
    let test = {diaryId:diaryId};
    let isDelete = confirm("정말 삭제하시겠습니까?")
    if(isDelete){
        $.ajax({
            url: "/restDiary/deleteDiary",
            method: "get",
            dataType: "json",
            data : test,
            contentType : "application/text",
            success: function (response){
                $("#"+diaryId).remove();
            }

        });
    }

}
function recoverDiary(diaryId){
    let test = {diaryId:diaryId};
    let isRecover = confirm("복구하시겠습니까?")
    if(isRecover){
        $.ajax({
            url: "/restDiary/recoverDiary",
            method: "get",
            dataType: "json",
            data : test,
            contentType : "application/text",
            success: function (response){
                $("#"+diaryId).remove();
            }

        });
    }

}
function moveToBin(diaryId){
    let test = {diaryId : diaryId};
    let isMove = confirm("휴지통으로 보내시겠습니까?")
    if(isMove){
        $(function(){
            $.ajax({
                url : "/restDiary/moveToBin",
                type : "POST",
                data : JSON.stringify(test),
                contentType : "application/json",
                success: function (list){
                    $("div [name='listSet']").remove();
                    $.each(list,function(i,item){
                        if (item.imageName!=null) {
                            $(".listDiary").append(
                                "<div id='"+item.diaryId+"' name='listSet' class='col-md-4 col-lg-3 item'>"+
                                "<div class='box' style=\"background-image:url("+item.imageName+"); background-repeat:no-repeat; background-size: cover;\">" +
                                // "<input type=\"text\" class=\"diaryText\"  value=\"" + item.diaryText +"\" hidden style=\"position: absolute\">" +
                                "<div class='cover'>" +
                                "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                                "<p class='title'>"+item.diaryDate+"</p>" +
                                "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                                "<div class='social'><a href='#'><i onclick=\"moveToBin("+item.diaryId+")\" class='fas fa-trash-alt'></i></a></div>" +
                                "</div>" +
                                "</div>"+
                                "</div>"
                            )
                        }else{
                            $(".listDiary").append(
                                "<div id='"+item.diaryId+"' name='listSet' class='col-md-4 col-lg-3 item'>"+
                                "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                                // "<input type=\"text\" class=\"diaryText\"  value=\"" + item.diaryText +"\" hidden style=\"position: absolute\">" +
                                "<div class='cover'>" +
                                "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                                "<p class='title'>"+item.diaryDate+"</p>" +
                                "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                                "<div class='social'><a href='#'><i onclick=\"moveToBin("+item.diaryId+")\" class='fas fa-trash-alt'></i></a></div>" +
                                "</div>" +
                                "</div>"+
                                "</div>"

                            )
                        }
                    })
                }
            });
        })
    }


}

function getDiary(diaryId){
    location.href= "/diary/getDiary?diaryNo="+diaryId;
}

function back(){
    history.go(-1);
}

$(function($) {
    $("body").css("display", "none");
    $("body").fadeIn(2000);
    $("a.transition").click(function(event){
        event.preventDefault();
        linkLocation = this.href;
        $("body").fadeOut(1000, redirectPage);
    });
    function redirectPage() {
        window.location = linkLocation;
    }
});
$(function(){
    $(window).scroll(function() {
        console.log($(window).scrollTop());
        if ($(window).scrollTop() == $(document).height() - $(window).height()) {
            console.log(startNumber);
            console.log(endNumber);
            startNumber = startNumber+13;
            endNumber = endNumber+12;
            if(condition===0){
                $.ajax({
                    url : "/restDiary/getDiaryList",
                    type : "GET",
                    data :{
                        userId:$("#userId").val(),
                        startNum:Number(startNumber),
                        endNum:Number(endNumber)
                    },
                    contentType : "application/json",
                    success: function (list){
                        console.log(list);

                        document.getElementById('fisrtTab').setAttribute('class', 'active');
                        document.getElementById('secondTab').setAttribute('class', '');
                        document.getElementById('thirdTab').setAttribute('class', '');
                        document.getElementById('deleteBtn').setAttribute('class', '');
                        $.each(list,function(i,item){
                            console.log(item);
                            if (item.imageName!=null) {
                                $(".listDiary").append(
                                    "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                                    "<div class='box' style=\"background-image:url("+item.imageName+"); background-repeat:no-repeat; background-size: cover;\">" +
                                    // "<input type=\"text\" class=\"diaryText\"  value='" + item.diaryText + "' hidden style=\"position: absolute\">" +
                                    "<div class='cover'>" +
                                    "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                                    "<p class='title'>"+item.diaryDate+"</p>" +
                                    "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                                    "<div class='social'><a href='#'><i onclick=\"moveToBin("+item.diaryId+")\" class='fas fa-trash-alt'></i></a></div>" +
                                    "</div>" +
                                    "</div>"+
                                    "</div>"
                                )
                            }else{
                                $(".listDiary").append(
                                    "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                                    "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                                    // "<input type=\"text\" class=\"diaryText\"  value='" + item.diaryText +"' hidden style=\"position: absolute\">" +
                                    "<div class='cover'>" +
                                    "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                                    "<p class='title'>"+item.diaryDate+"</p>" +
                                    "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                                    "<div class='social'><a href='#'><i onclick=\"moveToBin("+item.diaryId+")\" class='fas fa-trash-alt'></i></a></div>" +
                                    "</div>" +
                                    "</div>"+
                                    "</div>"

                                )
                            }
                        })
                    }
                });
            }else if(condition===1){
                $.ajax({
                    url: "/restDiary/getOthersDiaryList",
                    method: "get",
                    dataType: "json",
                    data : {
                        userId:$("#userId").val(),
                        startNum:startNumber,
                        endNum:endNumber},
                    headers: { //excess 제어요청 헤더, n : v 형식으로 헤더 추가하면 url의 request header에서 해당 헤더로 값을 얻어올 수 있다.
                        "Accept": "application/json",
                        "Content-Type": "application/json"
                    },
                    success: function (list){
                        console.log(list);
                        document.getElementById('fisrtTab').setAttribute('class', '');
                        document.getElementById('secondTab').setAttribute('class', '');
                        document.getElementById('deleteBtn').setAttribute('class', '');
                        document.getElementById('thirdTab').setAttribute('class', 'active');
                        $.each(list,function(i,item){
                            console.log(item);
                            if (item.imageName!=null) {
                                $(".listDiary").append(
                                    "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                                    "<div class='box' style=\"background-image:url("+item.imageName+"); background-repeat:no-repeat; background-size: cover;\">" +
                                    // "<input type='hidden' class=\"diaryText\"  value=\"" + item.diaryText +"\" hidden style=\"position: absolute\">" +
                                    "<div class='cover'>" +
                                    "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                                    "<p class='title'>"+item.diaryDate+"</p>" +
                                    "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                                    "<div class='social'></div>" +
                                    "</div>" +
                                    "</div>"+
                                    "</div>"
                                )
                            }else{
                                $(".listDiary").append(
                                    "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                                    "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                                    // "<input type='hidden' class=\"diaryText\"  value=\"" + item.diaryText +"\" hidden style=\"position: absolute\">" +
                                    "<div class='cover'>" +
                                    "<h3 class='name' onclick=\"getDiary("+item.diaryId+")\">"+item.diaryTitle+"</h3>" +
                                    "<p class='title'>"+item.diaryDate+"</p>" +
                                    "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                                    "<div class='social'></div>" +
                                    "</div>" +
                                    "</div>"+
                                    "</div>"
                                )
                            }

                        })
                    }

                });
            }

        }
    });
})
