 <%@ page contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>

	<title>UploadifyTest</title>

	<script src="<%=basePath%>js/jquery-1.9.1.js" type="text/javascript"></script>
	<script src="<%=basePath%>js/jquery.uploadify.min.js" type="text/javascript"></script>

	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/uploadify.css">
	
	<script type="text/javascript">
		$(function() {
			$("#uploadify").uploadify({
				debug			: false, 

				swf 			: '<%=basePath%>js/uploadify.swf',	//swf文件路径
				method			: 'post',	// 提交方式
				uploader		: 'processUpload', // 服务器端处理该上传请求的程序(servlet, struts2-Action)

				preventCaching	: true,		// 加随机数到URL后,防止缓存

				buttonCursor	: 'hand',	// 上传按钮Hover时的鼠标形状
			//	buttonImage		: 'img/.....png',	// 按钮的背景图片,会覆盖文字
				buttonText		: 'select file'	, //按钮上显示的文字，默认”SELECTFILES”
				height			: 30	, // 30 px
				width			: 120	, // 120 px

				fileObjName		: 'filedata',	//文件对象名称, 即属性名
				fileSizeLimit	: 10000000	,		// 文件大小限制, 100 KB
				fileTypeDesc	: ''	,	//文件类型说明 any(*.*)
				fileTypeExts	: '*.zip;*.xlsx',		// 允许的文件类型,分号分隔
				formData		: {'id':'1', 'name':'myFile'} , //指定上传文件附带的其他数据。也动态设置。可通过getParameter()获取
				
				multi			: true ,	// 多文件上传
				progressData	: 'speed',	// 进度显示, speed-上传速度,percentage-百分比	
				queueID			: 'fileQueue',//上传队列的DOM元素的ID号
				queueSizeLimit	: 99	,	// 队列长度
				removeCompleted : false	,	// 上传完成后是否删除队列中的对应元素
				removeTimeout	: 10	,	//上传完成后多少秒后删除队列中的进度条, 
				requeueErrors	: true,	// 上传失败后重新加入队列
				uploadLimit		: 20,	// 最多上传文件数量

				successTimeout	: 30	,//表示文件上传完成后等待服务器响应的时间。超过该时间，那么将认为上传成功。
				
				// 在文件被移除出队列时触发	
				//onCancel : function(file) { alert( 'The file ' + file.name + ' was cancelled!' ); },
				
				// 在调用cancel方法且传入参数’*’时触发
				//onClearQueue : function (queueItemCount) { alert( queueItemCount + ' files were removed from the queue!' ); },

				// 打开文件对话框 关闭时触发
				onDialogClose : function (queueData) {
								/*	alert(
										"文件对话窗口中选了几个文件:" + queueData.filesSelected + "---" +
										"队列中加了几个文件:" + queueData.filesQueued + "---" +
										"队列中被替换掉的文件数:" + queueData.filesReplaced + "---" +
										"取消掉的文件数:" + queueData.filesCancelled + "---" + 
										"上传出错的文件数:" + queueData.filesErrored
									); */
								},
				
				// 选择文件对话框打开时触发
				onDialogOpen : function () { /*alert( 'please select files' ) */ },
			
				// 没有兼容的FLASH时触发
				onFallback : function(){ alert( 'Flash was not detected!' ) },
				
				// 每次初始化一个队列时触发, 即浏览文件后, 加入一个队列
				//onInit : function (instance) { alert( 'The queue ID is ' + instance.settings.queueID ) },
			
				// 上传文件处理完成后触发（每一个文件都触发一次）, 无论成功失败
				//onUploadComplete : function(file){ alert( 'The file ' + file.name + ' uploaded finished!' ) },

				// 上传文件失败触发
				onUploadError : function(file, errorCode, errorMsg, errorString){ 
                                    /*
                                    alert(
                                        file.name + ' upload failed! ' + 
                                        'errorCode: ' + errorCode +
                                        'errorMsg:' + errorMsg +
                                        'errorString:' + errorString
                                    );*/
								},
                
                // 在每一个文件上传成功后触发
                onUploadSuccess : function(file, data, response) {
                                    alert(
                                        file.name + ' is uploaded succeed!  ' +
                                        '  server-side returned data:' + data +
                                        '  response: ' + response
                                    );
                                  }

			});
		})
	</script>
</head>

<body>
	<h1>Uploadify Demo</h1>

	<p>
		<a href="javascript:$('#uploadify').uploadify('cancel','*')">clean queue</a>
	</p>
    <p>
		<a href="javascript:$('#uploadify').uploadify('cancel')">cancel first file</a>
	</p>
    <p>
		<a href="javascript:$('#uploadify').uploadify('stop', '*')">stop all files</a>
	</p>
    <p>
		<a href="javascript:$('#uploadify').uploadify('upload', '*')">start all files</a>
	</p>
	<div id="fileQueue"></div>

	<span id="uploadify"></span>

	


</body>
</html>