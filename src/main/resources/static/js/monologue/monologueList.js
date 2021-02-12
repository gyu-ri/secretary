$("#tab2").on("click", function(){
	var otherMonologueList=[];
	$.ajax({
		url: "/restMonologue/getOtherMonologueList",
        method: "get",
        dataType: "json",
        data:{shareStatus:"1", userId:$("#userId").val()},
		success:function(otherMonologueList){
			console.log(otherMonologueList);
			$.each(otherMonologueList,function(index,item){
				console.log(index+"="+item.monologueText);
				$("#otherMonologue").appen("item.monologueText");
			})
		},
		  error: function(xhr, status, error) {
              alert(error);
          }
		
	
	
            
	})
})