/**
 * 
 */

	window.onload = function(){ 
		changeColor();
	};
	
	function changeColor(){
		
		$("#menuTable tr td").each(function(i){
			$(this).click(function(){
				$(this).siblings().attr("class","menuTable");
				$(this).attr("class","menuTable selected");
				
				if($(this).attr("id")=="membersMessageId"){
					$("#membersMessage").css("display","block");
					$("#liveAbroad").css("display","none");
					$("#homeStyle").css("display","none");
					$("#charityActivity").css("display","none");
					$("#charityOrganize").css("display","none");
				}
				else if($(this).attr("id")=="liveAbroadId"){
					$("#membersMessage").css("display","none");
					$("#liveAbroad").css("display","block");
					$("#homeStyle").css("display","none");
					$("#charityActivity").css("display","none");
					$("#charityOrganize").css("display","none");
				}
				else if($(this).attr("id")=="homeStyleId"){
					$("#membersMessage").css("display","none");
					$("#liveAbroad").css("display","none");
					$("#homeStyle").css("display","block");
					$("#charityActivity").css("display","none");
					$("#charityOrganize").css("display","none");
				}
				else if($(this).attr("id")=="charityActivityId"){
					$("#membersMessage").css("display","none");
					$("#liveAbroad").css("display","none");
					$("#homeStyle").css("display","none");
					$("#charityActivity").css("display","block");
					$("#charityOrganize").css("display","none");
				}
				else if($(this).attr("id")=="charityOrganizeId"){
					$("#membersMessage").css("display","none");
					$("#liveAbroad").css("display","none");
					$("#homeStyle").css("display","none");
					$("#charityActivity").css("display","none");
					$("#charityOrganize").css("display","block");
				}
			});			
		});
	}
