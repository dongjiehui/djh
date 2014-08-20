/**
 * 
 */
	window.onload = function(){ 
		changeColor();
	};
	
	function changeColor(){
		
		$("#qlintroLeft ul li").each(function(i){
			$(this).click(function(){
				$(this).siblings().attr("class","");
				$(this).attr("class","selected");
				var divName=$(this).attr("id");
				if(divName=="qljj"){
					$("#qlintro").css("display","block");
					$("#organizeChart").css("display","none");
					$("#rules").css("display","none");
				}
				else if(divName=="zzjg"){
					$("#qlintro").css("display","none");
					$("#organizeChart").css("display","block");
					$("#rules").css("display","none");
				}
				else if(divName=="zc"){
					$("#qlintro").css("display","none");
					$("#organizeChart").css("display","none");
					$("#rules").css("display","block");
				}
			});
		});
	}
