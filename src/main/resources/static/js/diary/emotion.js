function goWrite(){
    var emotion = document.emotionSelect.emotionNo.value;
    if(emotion.trim() == ''){
        alert(emotion);
        alert("감정을 선택해주세요");
        return false;
    }else{
        // alert(emotion + "선택됨");
        return true;
    }
}