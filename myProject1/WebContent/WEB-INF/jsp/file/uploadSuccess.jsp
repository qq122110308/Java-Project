<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons_js.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传成功</title>
<!-- Select2 -->
  <link rel="stylesheet" href="../bower_components/select2/dist/css/select2.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 头部 -->
		<jsp:include page="../commons/top.jsp" ></jsp:include>
		<!-- 左侧 -->
		<jsp:include page="../commons/left.jsp" ></jsp:include>
	
		<!-- 内容 -->
		<div class="content-wrapper">
			
		<!-- subTop begin-->
		<section class="content-header">
	      <h1>
	       	上传成功
	        <small>预览</small>
	      </h1>
	      <ol class="breadcrumb">
	        <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
	        <li><a href="#">上传成功</a></li>
	        <li class="active">上传成功</li>
	      </ol>
	    </section>
	    <!-- subTop end-->
	    
	    <!-- content -->
		<section class="content">
		上传成功！
		
		</section>
		
		<!-- 需要显示的内容 -->
		</div>
		
		<!-- 尾部 -->
		<jsp:include page="../commons/bottom.jsp" ></jsp:include>
			
	</div>
	


</body>
</html>