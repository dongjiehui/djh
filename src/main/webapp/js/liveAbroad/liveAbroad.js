/**
 * 
 */

$(function(){
	loadData();
});

function loadData(){
	$.ajax({
		type:'get',
		dataType:'json',
		async:false,
		url:'../../liveAbroad?size=5',
		data:{
			
		}, 
		success: function(data){								
			showLiveAbroad(data);
		},
		error: function(XMLHttpRequest,textStatus,errorThrown) {	 
								
		}
	});	
}

function showLiveAbroad(data){
	$("#lifeStateUl").html("");
	if(data.content.length>0)
	{		
		$.each(data.content,function(i,val){				
			$("#lifeStateUl").append('<li><div class="col-xs-12 lifeTitle" >'+val.title+'</div>'
								+'<div class="viewsFont"><div class="col-xs-5">浏览次数：'+val.clickNum+'</div>'
								+'<div class="col-xs-7 publishData">发布日期：'+val.publishDate+'</div></div></li>')
		});
	}
}