<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../commons/commons_js.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>任务测试</title>
</head>
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
		      <h1>任务功能
		        <small>表格</small>
		      </h1>
		      <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
		        <li><a href="#">任务管理</a></li>
		        <li class="active">任务测试</li>
		      </ol>
		    </section>
		    <!-- 表格 -->
		    <section class="content">
		      <div class="row">
		        <div class="col-md-12">
		    		<div class="box">
		            <div class="box-header with-border">
		              <h3 class="box-title">任务测试</h3>
		            </div>
		            <!-- /.box-header -->
		            <div class="box-body">
		            	<div class="form-group">
		            		<input type="button" onclick="executeTask()" class="btn btn-primary" value="任务" />
		            	</div>
		            </div>
		            <!-- /.box-body -->
		            </div>
		            <!-- /.box -->
		    	</div>
		      </div>
		    </section>  		
		</div>
		<!-- 内容 -->
		
		<!-- 尾部 -->
		<jsp:include page="../commons/bottom.jsp" ></jsp:include>
		
		<!-- 引入模态框 -->	
		<jsp:include page="../commons/modal.jsp"></jsp:include>
		
	</div>
	
<script type="text/javascript">
	$(function(){
		//加载左侧项目栏菜单,先看效果怎么样
		
	});
</script>
</body>
</html>