/**
 * 
 */
	window.onload = function(){ 
		changeColor();
	};
	
	function changeColor(){
		
		$(".head-bottom div").each(function(i){
			$(this).click(function(){
				$(this).siblings().attr("class","col-xs-2");
				$(this).attr("class","col-xs-2 colorSelect");
			});
		});
	}
