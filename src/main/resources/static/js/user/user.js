//아이디 유효성 검사
function idCheck() {
    let userId = $('#userId').val();
    $.ajax({
        url: '/restUser/idCheck',
        type: 'get',
        data: {userId: userId},
        contentType: "application/json",
        success: function (data) {
            console.log("1=중복/0=중복아님" + data);

            if (data == 1) {
                $("#idCheck").text("이미 존재하는 아이디입니다.");
                $("#idCheck").css("color", "red");
                $("#submit").attr("disabled", true);
            } else {
                $("#idCheck").text("사용가능한 아이디입니다.");
                $("#idCheck").css("color", "blue");
                $("#submit").attr("disabled", true);
            }

            /*if($("#password1").val().length >= 8){
                $("#8char").removeClass("glyphicon-remove");
                $("#8char").addClass("glyphicon-ok");
                $("#8char").css("color","#00A41E");
            }else{
                $("#8char").removeClass("glyphicon-ok");
                $("#8char").addClass("glyphicon-remove");
                $("#8char").css("color","#FF0004");
            }*/

        }, error: function () {
            console.log("실패");
        }
    });
}

//회원가입 본인인증
function sendMail() {// 메일 입력 유효성 검사
    let mail = $("#email").val(); //사용자의 이메일 입력값.
    if (mail == "") {
        alert("메일 주소가 입력되지 않았습니다.");
    } else {
        //mail = mail+"@"+$(".domain").val(); //셀렉트 박스에 @뒤 값들을 더함.
        $.ajax({
            type: 'post',
            url: '/restUser/CheckMail',
            data: {
                mail: mail
            },
            dataType: 'json',
            success: function (key) {
                alert("인증번호가 전송되었습니다.")
                $('#check').attr("value", key);
            }
        });

        isCertification = true; //추후 인증 여부를 알기위한 값
    }
}

function checkCertificationNo() {
    alert("인증번호 맞는지 확인할게욥")

    let checkKey = $('#check').val();
    if ($("#certificationNo").val() == checkKey) { //인증 키 값의 비교를 위해 텍스트인풋과 벨류를 비교
        console.log("key" + checkKey);
        $("#certificationNo").text("인증완료").css("color", "blue");
        alert("인증이 완료되었습니다.")
        isCertification = true; //인증성공여부 check
    } else {
        $("#certificationNo").text("불일치").css("color", "red");
        isCertification = false; //인증실패
        alert("인증이 실패했습니다.")
    }
}

function submitCheck(){
    if (isCertification == false){
        alert("메일 인증이 완료되지 않았습니다.");
        return false;
    }else true;
}

function pwdCheck(){

    if($("#password01").val() == $("#password02").val()){
        $("#pwmatch").removeClass("glyphicon-remove");
        $("#pwmatch").addClass("glyphicon-ok");
        $("#pwmatch").css("color","#0029a4");
    }else{
        $("#pwmatch").removeClass("glyphicon-ok");
        $("#pwmatch").addClass("glyphicon-remove");
        $("#pwmatch").css("color","#FF0004");
    }
}

//Kakao.init('b924b1b6cefccb2c71d88231552b32a8');

/*
$(document).ready(function (){
    Kakao.init('b924b1b6cefccb2c71d88231552b32a8');
        alert("test");
        const token = $("#token").val();
        console.log(token)
        Kakao.Auth.setAccessToken(token)
        Kakao.API.request({
            url: '/v2/user/me',
            success: function(response) {
                /!*alert(JSON.stringify(response));
                alert(JSON.stringify(authObj));
                console.log(response.id);
                console.log(response.email);
                console.log(authObj.accessToken);*!/
                console.log(JSON.stringify(response));
                $("#userId").attr('value',response.id);
                $("#password01").attr('value',response.id);
                $("#userName").attr('value',response.properties.nickname);
                $("#email").attr('value',response.kakao_account.email);
            },
            fail: function(error) {
                alert(JSON.stringify(error));
                console.log(error);
            }
        });
})*/
