<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons_js.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>短信测试</title>
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
	        短信
	        <small>测试</small>
	      </h1>
	      <ol class="breadcrumb">
	        <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
	        <li><a href="#">短信测试</a></li>
	        <li class="active">短信测试</li>
	      </ol>
	    </section>
	    <!-- subTop end-->
	    
	    <!-- content -->
		<section class="content">
			<div class="box box-default">
	        <div class="box-header with-border">
	          <h3 class="box-title">test</h3>
	
	          <div class="box-tools pull-right">
	            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
	            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
	          </div>
	        </div>
	        <!-- /.box-header -->
	        <div class="box-body">
	          
	          <div class="row">
	          	<label class="control-label col-sm-2">手机号</label>	
	          	<div class="col-sm-10">
	          		<input class="form-group" value="" name="phone" placeholder="请输入手机号" />
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