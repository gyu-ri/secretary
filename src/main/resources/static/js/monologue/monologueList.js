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




$(function(){
	
$("#getMonologueList").click(function(){

    $.ajax({
        url : "/restMonologue/getMonologueList",
        type : "GET",
        data :{userId:$("#userId").val()},
        success: function (list){
            console.log(list);

            $("div [name='listSet']").remove();
            document.getElementById('fisrtTab').setAttribute('class', 'active');
            document.getElementById('secondTab').setAttribute('class', '');
            document.getElementById('thirdTab').setAttribute('class', '');
            $.each(list,function(i,item){
                   console.log(item);
                   $(".monologueList").append(
                   		"<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                   		"<div onclick=\"getMonologue("+item.monologueId+","+item.questionId+")\" style=\"cursor:pointer;font-size:15px; height:20px; color:black;\">"+
                   		item.questionText+
                   		"</div>"+
                   		"</div>"
                   )
            })
        }
})
})

                    	
    

$("#getOthersMonologueList").on("click", function () {
//    var list = [];
    
    $.ajax({
        url: "/restMonologue/getOtherMonologueList",
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
            document.getElementById('secondTab').setAttribute('class', 'active');
            document.getElementById('thirdTab').setAttribute('class', '');
            $.each(list.reverse(),function(i,item){
                console.log(item);
                $(".otherList").append(
                		"<div name=\"listSet\" >"+
                		"<div onclick=\"getMonologue("+item.monologueId+","+item.questionId+")\" style=\"cursor:pointer;font-size:15px; height:20px; color:black;\">"+
                		item.questionText+
                		"</div>"+
                		"</div>"
                )
            })
        }
    
    });
  /*  return list;*/
});

$("#deleteMonologue").click(function(){

    $.ajax({
        url : "/restMonologue/getMonologueList",
        type : "GET",
        data :{userId:$("#userId").val()},
        success: function (list){
            console.log(list);

            $("div [name='listSet']").remove();
            document.getElementById('fisrtTab').setAttribute('class', '');
            document.getElementById('secondTab').setAttribute('class', '');
            document.getElementById('thirdTab').setAttribute('class', 'active');
            $.each(list,function(i,item){
                   console.log(item);
                   $(".monologueList").append(
                   		"<div name=\"listSet\" class='col-md-4 col-lg-3 item'>"+
                   		/*"<div onclick=\"getMonologue("+item.monologueId+","+item.questionId+")\" style=\"cursor:pointer;font-size:15px; height:20px; color:black;\">"+*/
                   		"<label>"+
                   		item.questionText+
                   		"<input type=\"checkbox\" name=\"delete\">"+
                   		"</label>"+
                   		
                   		/*"</div>"+*/
                   		"</div>"
                   )
            })
            $(".monologueList").append(
            "<input type=\"submit\" name=\"deleteMonologue\" value=\"삭제하기\">"
            )
        }
})
})

})


function getMonologue(monologueId,questionId){
    location.href= "/monologue/getMonologue?monologueId="+monologueId+'&questionId='+questionId;
}
