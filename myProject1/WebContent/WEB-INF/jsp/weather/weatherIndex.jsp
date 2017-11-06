<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons_js.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传</title>
<!-- Select2 -->
  <link rel="stylesheet" href="../bower_components/select2/dist/css/select2.min.css">
</head>

<script type="text/javascript" src="../js/weather/index.js"></script>	

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
	        天气
	        <small>查询</small>
	      </h1>
	      <ol class="breadcrumb">
	        <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
	        <li><a href="#">天气查询</a></li>
	        <li class="active">天气查询</li>
	      </ol>
	    </section>
	    <!-- subTop end-->
	    
	    <!-- content -->
		<section class="content">
			<div class="box box-default">
	        <div class="box-header with-border">
	          <h3 class="box-title">你选择</h3>
	
	          <div class="box-tools pull-right">
	            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
	            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
	          </div>
	        </div>
	        <!-- /.box-header -->
	        <div class="box-body">
	          
	          <div class="row">
	          	<div class="col-md-6">
	          		<select class="form-control" id="city">
	          			<option value="">请选择</option>
	          			<c:forEach var="obj" items="${weather}" varStatus="status">
	          				<option value="${obj.cityid }">${obj.city}</option>
	          			</c:forEach>
	          		</select>
	          	</div>
	          	
	          	<div class="col-md-6">
	          		<button class="btn btn-primary" id="findWeather">查询</button>
	          	</div>
	          </div>
	          
	          <div class="row">
	          	<div class="col-md-12">
	          		<textarea rows="5" cols="10" class="form-control" id="showMessage" ></textarea>
	          	</div>
	          </div>
	          
	          
	          
	          <!-- /.row -->
	        </div>
	        <!-- /.box-body -->
	        <div class="box-footer" style="display:none;" >
	          Visit <a target="_blank"  href="http://bd.kuwo.cn/yinyue/3389146?from=baidu;">敌不过的哪是似水流年</a> <font style="font-family: Microsoft YaHei;">--上邪</font>
	        </div>
	      </div>
		</section>
		
		<!-- 需要显示的内容 -->
		</div>
		
		<!-- 尾部 -->
		<jsp:include page="../commons/bottom.jsp" ></jsp:include>
			
	</div>
	

	

</body>
</html>