/**
 * 
 */

$(function(){
	loadTopData();
	loadBottomData();
});

function loadTopData(){
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

function loadBottomData(){
	$.ajax({
		type:'get',
		dataType:'json',
		async:false,
		url:'../../liveAbroad?size=12',
		data:{
			
		}, 
		success: function(data){								
			showBottomData(data);
		},
		error: function(XMLHttpRequest,textStatus,errorThrown) {	 
								
		}
	});	
}

function showBottomData(data){
	$("#bottomImgDiv").html("");
	var imgDivHtml="";
	if(data.content.length>0)
	{		
		$.each(data.content,function(i,val){	
			if(i%4==0){
				imgDivHtml+='<div class="col-xs-12 imageDiv">';
			}
			imgDivHtml+='<div class="col-xs-3"><img class="col-xs-12" style="height:200px" src="../../liveAbroad/getImgsById?id='+val.id+'" /><h3>'+val.title+'</h3></div>';
			if(i%4==3){
				imgDivHtml+='</div>';
			}
		});
		$("#bottomImgDiv").append(imgDivHtml);
	}
}

function showLiveAbroad(data){
	$("#lifeStateUl").html("");
	if(data.content.length>0)
	{		
		$.each(data.content,function(i,val){				
			$("#lifeStateUl").append('<li><div class="col-xs-12 lifeTitle" >'+val.title+'</div>'
								+'<div class="viewsFont"><div class="col-xs-5">浏览次数：'+val.clickNum+'</div>'
								+'<div class="col-xs-7 publishData">发布日期：'+val.publishDate+'</div></div></li>');
		});
	}
}