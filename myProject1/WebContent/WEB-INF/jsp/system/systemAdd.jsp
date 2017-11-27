<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"  pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>功能添加</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 头部 -->
		<jsp:include page="../commons/top.jsp" ></jsp:include>
		<!-- 左侧 -->
		<jsp:include page="../commons/left.jsp" ></jsp:include>
		
		<!-- 内容 -->
		<div class="content-wrapper">
			<!-- 内容排版 subTop-->
			<section class="content-header">
			
			  <h1>
		        	添加
		        <small>查看</small>
		      </h1>
		      <ol class="breadcrumb">
		        <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
		        <li><a href="#">系统管理</a></li>
		        <li class="active">系统功能</li>
		        <li>功能添加</li>
		      </ol>
			</section>
			<!-- 内容排版 subTop -->
			<!-- 需要显示的内容 -->
				<section class="content">
					<div class="row">
						<div class="col-md-12">
						<div class="box box-primary">
			            <div class="box-header with-border">
			              <h3 class="box-title">添加</h3>
			            </div>
						<form class="form-horizontal" action="add" method="post" >
			              <div class="box-body">
			                <div class="form-group">
			                  <label  class="col-sm-2 control-label">功能名称</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" class="form-control" name="funname" id="" placeholder="添加功能名称">
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label  class="col-sm-2 control-label">功能地址</label>
			
			                  <div class="col-sm-10">
			                    <input type="text" class="form-control" name="funurl" id="" placeholder="添加功能地址">
			                  </div>
			                </div>
			                <div class="form-group">
			                  <label  class="col-sm-2 control-label">图标</label>
			                  <div class="col-sm-10">
			                    <input type="text" class="form-control" name="funicon" id="" placeholder="添加图标">
			                  </div>
			                </div>
			                <div class="form-group">
			                	<label  class="col-sm-2 control-label">上级目录</label>
			                	<div class="col-sm-10">
				                	<select class="form-control" name="funfathernode" >
				                		<option value="0">请选择</option>
				                		<!-- 这里我只显示顶级目录 -->
				                		<c:forEach var="list" items="${funList }" varStatus="status">
											<c:if test="${list.funfathernode eq '0' }">
												<option value="${list.funid }">${list.funname }</option>
											</c:if>
											
				                		</c:forEach>
				                	</select>
				                </div>	
			                </div>
			              </div>
			              <!-- /.box-body -->
			              <div class="box-footer">
			                <button type="button" onclick="window.history.go(-1)"  class="btn btn-default">取消</button>
			                <button type="submit" class="btn btn-info pull-right">确认</button>
			              </div>
			              <!-- /.box-footer -->
			            </form>					
			            </div>
						</div>
					</div>
					
				</section>
			<!-- 需要显示的内容 -->
		</div>	
		<!-- 内容 -->
		
		<!-- 尾部 -->
		<jsp:include page="../commons/bottom.jsp" ></jsp:include>
		
	</div>
	
<!-- jQuery 3 -->
<script src="../bower_components/jquery/dist/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="../bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="../bower_components/raphael/raphael.min.js"></script>
<script src="../bower_components/morris.js/morris.min.js"></script>
<!-- Sparkline -->
<script src="../bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="../bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="../bower_components/moment/min/moment.min.js"></script>
<script src="../bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- datepicker -->
<script src="../bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="../bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="../bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="../dist/js/adminlte.min.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="../dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="../dist/js/demo.js"></script>
	
<script type="text/javascript">
	$(function(){
		//加载左侧项目栏菜单,先看效果怎么样
		
	});
</script>
	
	
</body>
</html>