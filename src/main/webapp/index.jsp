<html>
<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<link rel="stylesheet" href="../../css/bootstrap.css" type="text/css">
		<link rel="stylesheet" href="../../responsive.css" type="text/css">
		<link rel="stylesheet" href="../../css/publish/publishCommon.css" type="text/css">		
		
		
		<link rel="stylesheet" href="../../js/editor/themes/default/default.css" />
		<link rel="stylesheet" href="../../js/editor/plugins/code/prettify.css" />
		<script charset="utf-8" src="../../js/editor/kindeditor.js"></script>
		<script charset="utf-8" src="../../js/editor/lang/zh_CN.js"></script>
		<script charset="utf-8" src="../../js/editor/plugins/code/prettify.js"></script>
		
		
		<script type="text/javascript" src="../../js/jquery-1.8.2.js"></script>
		<script type="text/javascript" src="../../js/bootstrap.js"></script>
		<script type="text/javascript">
		function pub(){
        	alert("提交表单！");
        	//alert($('#liveAbroadForm').serialize());
        	$.ajax({
                type: "POST",
                url:"http://localhost:8080/liveAbroad",
                contentType: "application/json",
                data: "{\"title\": \"aaaa\", \"contents\": \"ddddddddddddddddddddddddddddd\", \"user\": {\"id\": 1}}",
                async: false,
                success: function(data) {
                	alert("数据提交成功！");
                    //$("#commonLayout_appcreshi").parent().html(data);
                },
                error: function(request) {
                    alert("提交失败！");
                }
            });
        }
		</script>
</head>
<body>
<h2>Hello World!</h2>
<input type="button" onclick="pub();" value="aa" />
</body>
</html>
