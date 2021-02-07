function loginWithKakao() {
    Kakao.Auth.authorize({
        redirectUri: 'http://localhost:9090/user/kakaologin' //토큰을 가지고 가는 경로
    })
}

function loginValiCheck(){
    alert("로그인 체크를 실행해볼겁니다!");
    /*let userId = $('#userId').val();
    let password = $('#password').val();
    let userName = $('#userName').val();*/
    $.ajax({
        url: '/restUser/loginCheck',
        method: 'get',
        dataType: 'json',
        data: {userId: $('#userId').val(),
                password: $('#password').val(
                )},
        contentType: "application/json",
        success: function (data){
            console.log("로그인 가능합니다"+data);
            alert("로그인 체크를 실행해볼겁니다!"+data);
            if (data == 0){
                alert("if 체크를 실행해볼겁니다!"+data);
                // $("#loginCheck").text("가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
                // $("#loginCheck").css("color", "#ae0f11");
                // $("#submit").attr("disabled", true);
                $('#message').remove();
                $('.check_font').append("<div id='message'>가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.</div>")
                $('.check_font').css("color","#ae0f11")
                $('#login').preventDefault();
                return false;
            }else{
                document.login.submit();
            }
        }, error: function (){
            console.log("실패실패");
        }
    });
}

/*$('#login-button').click(function(){
    $('#login-button').fadeOut("slow",function(){
        $("#container").fadeIn();
        TweenMax.from("#container", .4, { scale: 0, ease:Sine.easeInOut});
        TweenMax.to("#container", .4, { scale: 1, ease:Sine.easeInOut});
    });
});*/

/*$(".close-btn").click(function(){
    TweenMax.from("#container", .4, { scale: 1, ease:Sine.easeInOut});
    TweenMax.to("#container", .4, { left:"0px", scale: 0, ease:Sine.easeInOut});
    $("#container, #forgotten-container").fadeOut(800, function(){
        $("#login-button").fadeIn(800);
    });
});*/

/*$('#findId').click(function(){
    $("#container").fadeOut(function(){
        $("#findId-container").fadeIn();
    });
});*/

$(function() {
    $('#findId').on("click", function () {
        $("#findId-modal").modal("show");
    })
    $("#sendEmail").on("click",function(e){
        let text = {
            userName : $("#userName").val(),
            email : $("#email").val()
        };
        $.ajax({
            url: "/restUser/findId",
            type: "POST",
            data: JSON.stringify(text),
            contentType: "application/json",
            success: function (response) {
                alert(response);
            }, error: function () {
                console.log("실패실패");
                alert()
                $('#message').remove();
                $('.check_info').append("<div id='message'>회원정보가 일치하지 않습니다.</div>")
                $('.check_info').css("color", "#ae0f11")
                $('#sendEmail').preventDefault();
            }
        })
        //$("#updateUser").submit();
        //location.href="/user/login";

    })

})