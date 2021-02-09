
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
                            "<a href='/diary/getDiary?diaryNo="+item.diaryId+"'>" +
                            "<div class='cover'>" +
                            "<h3 class='name'>"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i onclick=\"deleteDiary("+item.diaryId+")\" class='fas fa-trash-alt'></i></a><a href='#'><i class='fas fa-trash-restore' onclick=\"recoverDiary("+item.diaryId+")\"></i></a></div>" +
                            "</div>" +
                            "</a>"+
                            "</div>"+
                            "</div>"
                        )
                    }else{
                        $(".listDiary").append(
                            "<div id='"+item.diaryId+"' name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                            "<a href='/diary/getDiary?diaryNo="+item.diaryId+"'>" +
                            "<div class='cover'>" +
                            "<h3 class='name'>"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i onclick=\"deleteDiary("+item.diaryId+")\" class='fas fa-trash-alt'></i></a><a href='#'><i class='fas fa-trash-restore' onclick=\"recoverDiary("+item.diaryId+")\"></i></a></div>" +
                            "</div>" +
                            "</a>"+
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

        $.ajax({
            url : "/restDiary/getDiaryList",
            type : "GET",
            data :{userId:$("#userId").val()},
            success: function (list){
                console.log(list);
                let rev = list.reverse();
                $("div [name='listSet']").remove();
                document.getElementById('fisrtTab').setAttribute('class', 'active');
                document.getElementById('secondTab').setAttribute('class', '');
                document.getElementById('thirdTab').setAttribute('class', '');
                document.getElementById('deleteBtn').setAttribute('class', '');
                $.each(rev,function(i,item){
                    console.log(item);
                    if (item.imageName!=null) {
                        $(".listDiary").append(
                            "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url("+item.imageName+"); background-repeat:no-repeat; background-size: cover;\">" +
                            "<a href='/diary/getDiary?diaryNo="+item.diaryId+"'>" +
                            "<div class='cover'>" +
                            "<h3 class='name'>"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i onclick=\"moveToBin("+item.diaryId+")\" class='fas fa-trash-alt'></i></a></div>" +
                            "</div>" +
                            "</a>"+
                            "</div>"+
                            "</div>"
                        )
                    }else{
                        $(".listDiary").append(
                            "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                            "<a href='/diary/getDiary?diaryNo="+item.diaryId+"'>" +
                            "<div class='cover'>" +
                            "<h3 class='name'>"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i onclick=\"moveToBin("+item.diaryId+")\" class='fas fa-trash-alt'></i></a></div>" +
                            "</div>" +
                            "</a>"+
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

        $.ajax({
            url: "/restDiary/getOthersDiaryList",
            method: "get",
            dataType: "json",
            data : {shareStatus:"1",userId:$("#userId").val()},
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
                            "<a href='/diary/getDiary?diaryNo="+item.diaryId+"'>" +
                            "<div class='cover'>" +
                            "<h3 class='name'>"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i class='fa fa-facebook-official'></i></a><a href='#'><i class='fa fa-twitter'></i></a><a href='#'><i class='fa fa-instagram'></i></a></div>" +
                            "</div>" +
                            "</a>"+
                            "</div>"+
                            "</div>"
                        )
                    }else{
                        $(".listDiary").append(
                            "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                            "<a href='/diary/getDiary?diaryNo="+item.diaryId+"'>" +
                            "<div class='cover'>" +
                            "<h3 class='name'>"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i class='fa fa-facebook-official'></i></a><a href='#'><i class='fa fa-twitter'></i></a><a href='#'><i class='fa fa-instagram'></i></a></div>" +
                            "</div>" +
                            "</a>"+
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
                    $.each(list.reverse(),function(i,item){
                        console.log(item);
                        if (item.imageName!=null) {
                            $(".listDiary").append(
                                "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                                "<div class='box' style=\"background-image:url("+item.imageName+"); background-repeat:no-repeat; background-size: cover;\">" +
                                "<a href='/diary/getDiary?diaryNo="+item.diaryId+"'>" +
                                "<div class='cover'>" +
                                "<h3 class='name'>"+item.diaryTitle+"</h3>" +
                                "<p class='title'>"+item.diaryDate+"</p>" +
                                "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                                "<div class='social'><a href='#'><i class='fa fa-facebook-official'></i></a><a href='#'><i class='fa fa-twitter'></i></a><a href='#'><i class='fa fa-instagram'></i></a></div>" +
                                "</div>" +
                                "</a>"+
                                "</div>"+
                                "</div>"
                            )
                        }else{
                            $(".listDiary").append(
                                "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                                "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                                "<a href='/diary/getDiary?diaryNo="+item.diaryId+"'>" +
                                "<div class='cover'>" +
                                "<h3 class='name'>"+item.diaryTitle+"</h3>" +
                                "<p class='title'>"+item.diaryDate+"</p>" +
                                "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                                "<div class='social'><a href='#'><i class='fa fa-facebook-official'></i></a><a href='#'><i class='fa fa-twitter'></i></a><a href='#'><i class='fa fa-instagram'></i></a></div>" +
                                "</div>" +
                                "</a>"+
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
                            "<a href='/diary/getDiary?diaryNo="+item.diaryId+"'>" +
                            "<div class='cover'>" +
                            "<h3 class='name'>"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i onclick=\"moveToBin("+item.diaryId+")\" class='fas fa-trash-alt'></i></a></div>" +
                            "</div>" +
                            "</a>"+
                            "</div>"+
                            "</div>"
                        )
                    }else{
                        $(".listDiary").append(
                            "<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                            "<a href='/diary/getDiary?diaryNo="+item.diaryId+"'>" +
                            "<div class='cover'>" +
                            "<h3 class='name'>"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i onclick=\"moveToBin("+item.diaryId+")\" class='fas fa-trash-alt'></i></a></div>" +
                            "</div>" +
                            "</a>"+
                            "</div>"+
                            "</div>"

                        )
                    }

                })
            }
        });

    });

    $(function geoFindMe() {

        function success(position) {
            var latitude  = position.coords.latitude;
            var longitude = position.coords.longitude;
            const coordsObj = {
                latitude,
                longitude
            };
            var url = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon="+ longitude + "&appid=7d9ec3e89f78fa3eef02069216cce88c&units=metric";

            //saveCoords(coordsObj);
            getWeather(latitude, longitude);

        }


        function error() {
            status.textContent = 'Unable to retrieve your location';
        }

        if(!navigator.geolocation) {
            status.textContent = 'Geolocation is not supported by your browser';
        } else {
            status.textContent = '';
            navigator.geolocation.getCurrentPosition(success, error);
        }

        function getWeather(lat, lon){
            fetch(
                `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=7d9ec3e89f78fa3eef02069216cce88c&units=metric`
            )
                .then(function(response){
                    return response.json();
                })
                .then(function(json){
                    console.log(json);
                    const temparature = String(json.main.temp).substring(0,2);  //온도
                    const place = json.name;   // 사용자 위치
                    var icon = json.weather[0].icon;

                    $('#temparature').append(`${temparature}`)
                    $('#location').append(`${place}`)
                    $('#location1').attr("value", `${place}`)

                    $(".pic").removeClass("pic").addClass(icon);
                    var imgURL = "/images/weather/" + icon + ".png";
                    $('#img').attr("src", imgURL);
                    $('#weather').attr("value", imgURL);
                });


        }
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
    item = document.getElementsByClassName("thumbnail");
    console.log(value);
    console.log(item);

    for(i=0; i< item.length; i++){
        name = item[i].getElementsByClassName("diaryText");
        if(name[0].value.toUpperCase().indexOf(value) > -1){
            item[i].style.display = "flex";
        }else{
            item[i].style.display = "none";
        }
    }
}

function deleteDiary(diaryId){
    alert("DELETE");
    let test = {diaryId:diaryId};
    $.ajax({
        url: "/restDiary/deleteDiary",
        method: "get",
        dataType: "json",
        data : test,
        contentType : "application/text",
        success: function (response){
            alert(response);
            $("#"+diaryId).remove();
        }

    });
}
function recoverDiary(diaryId){
    alert("RECOVER");
    let test = {diaryId:diaryId};
    $.ajax({
        url: "/restDiary/recoverDiary",
        method: "get",
        dataType: "json",
        data : test,
        contentType : "application/text",
        success: function (response){
            alert(response);
            $("#"+diaryId).remove();
        }

    });
}
function moveToBin(diaryId){
    alert("move");
    let test = {diaryId : diaryId};
    $(function(){
        $.ajax({
            url : "/restDiary/moveToBin",
            type : "POST",
            data : JSON.stringify(test),
            contentType : "application/json",
            success: function (list){
                console.log(list);
                $("div [name='listSet']").remove();
                document.getElementById('fisrtTab').setAttribute('class', '');
                document.getElementById('secondTab').setAttribute('class', '');
                document.getElementById('thirdTab').setAttribute('class', '');
                document.getElementById('deleteBtn').setAttribute('class', 'active');

                $.each(list.reverse(),function(i,item){
                    console.log(item);
                    if (item.imageName!=null) {
                        $(".listDiary").append(
                            "<div id='"+item.diaryId+"' name='listSet' class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url("+item.imageName+"); background-repeat:no-repeat; background-size: cover;\">" +
                            "<a href='/diary/getDiary?diaryNo="+item.diaryId+"'>" +
                            "<div class='cover'>" +
                            "<h3 class='name'>"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i class='fa fa-facebook-official'></i></a><a href='#'><i class='fa fa-twitter'></i></a><a href='#'><i class='fa fa-instagram'></i></a></div>" +
                            "</div>" +
                            "</a>"+
                            "</div>"+
                            "</div>"
                        )
                    }else{
                        $(".listDiary").append(
                            "<div id='"+item.diaryId+"' name='listSet' class='col-md-4 col-lg-3 item'>"+
                            "<div class='box' style=\"background-image:url('/images/icon/book.png'); background-repeat:no-repeat; background-size: cover;\">" +
                            "<a href='/diary/getDiary?diaryNo="+item.diaryId+"'>" +
                            "<div class='cover'>" +
                            "<h3 class='name'>"+item.diaryTitle+"</h3>" +
                            "<p class='title'>"+item.diaryDate+"</p>" +
                            "<img src='"+item.weather+"' width='30px' height='30px'/>" +
                            "<div class='social'><a href='#'><i class='fa fa-facebook-official'></i></a><a href='#'><i class='fa fa-twitter'></i></a><a href='#'><i class='fa fa-instagram'></i></a></div>" +
                            "</div>" +
                            "</a>"+
                            "</div>"+
                            "</div>"

                        )
                    }
                })
            }
        });
    })

}



function back(){
    history.go(-1);
}