<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../commons/commons_js.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>邮箱发送</title>
</head>
<!-- 引入js -->
<script type="text/javascript" src="../js/email/index.js"></script>

<body class="hold-transition skin-blue sidebar-mini">
	
	<input type="hidden" id="alertMessage"  value="${message}" />
	<div class="wrapper">
		<!-- 头部 -->
		<jsp:include page="../commons/top.jsp" ></jsp:include>
		<!-- 左侧 -->
		<jsp:include page="../commons/left.jsp" ></jsp:include>
		
		<!-- 内容 -->
		
		<div class="content-wrapper">
			<section class="content-header">
		      <h1>邮件功能
		        <small>功能</small>
		      </h1>
		      <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
		        <li><a href="#">邮件功能</a></li>
		        <li class="active">邮件</li>
		      </ol>
		    </section>
		    <!-- 表格 -->
		    <section class="content">
		      <div class="row">
		        <div class="col-md-12">
		    		<div class="box">
		            <div class="box-header with-border">
		              <h3 class="box-title">邮件发送</h3>
		            </div>
		            <!-- /.box-header -->
		            <form action="emailSend" method="post"  >
		            
		            <div class="box-body"  >
		            	<div class="row">
							<div class="col-md-6">
							<center>
								<label class="col-sm-2 control-label">标题</label> 
								<input type="text"  name="topic" class="form-control" /><br/>	
														
								<label class="col-sm-2 control-label">内容</label> 
								<textarea rows="5" cols="10" name="content" class="form-control"></textarea>
							</center> 
							</div>
		            	</div>
		            	
		            	<div class="row">
		            		<div class="col-md-6">
		            			<button class="btn btn-primary">确认 </button>
		            		</div>
		            	</div>
		            	
		            </div>
		            <!-- /.box-body -->
		            
		          	</form>
		          </div>
		          <!-- /.box -->
		    	</div>
		      </div>
		    </section>  		
		</div>
				
		<!-- 内容 -->
		
		<!-- 尾部 -->
		<jsp:include page="../commons/bottom.jsp" ></jsp:include> 
		
		<jsp:include page="../commons/modal.jsp"></jsp:include>
		
	</div>
	
	<script type="text/javascript">
		
	</script>
	
	
	
</body>
</html>